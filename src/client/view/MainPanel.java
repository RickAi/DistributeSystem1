package client.view;

import interfaces.FileSystem;
import interfaces.UserSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import beans.DSUser;
import beans.feedbacks.UserFeedback;

import managers.ServiceManager;
import utils.Constants;

public class MainPanel extends JPanel {
	
	private JButton btnRemoveFile;
	private JButton btnDownload;
	private JButton btnAddFile;
	private JButton btnReport;
	private JButton btnLogout;
	private JButton btnDeleteUser;
	
	private JList<String> fileList;
	private FileListModel fileListModel;
	private JScrollPane fileScroll;
	
	private UserSystem userSystem;
	private FileSystem fileSystem;
	private ClientFrame clientFrame;
	
	
	public MainPanel(){
		initServices();
		initComponents();
		initLocations();
		initListeners();
	}
	
	
	private void initListeners() {
		MainPanelListener mainPanelListener = new MainPanelListener();
		btnLogout.addActionListener(mainPanelListener);
		btnDeleteUser.addActionListener(mainPanelListener);
		FileListSelectionListener  fileSelectionListener = new FileListSelectionListener();
		fileList.addListSelectionListener(fileSelectionListener);
	}


	private void initServices() {
		userSystem = ServiceManager.userSystem;
		fileSystem = ServiceManager.fileSystem;
		clientFrame = ServiceManager.clientFrame;
	}

	private void initLocations() {
		btnReport.setBounds(30, 10, 100, 30);
		btnAddFile.setBounds(30, 50, 100, 30);
		btnDownload.setBounds(30, 90, 100, 30);
		btnRemoveFile.setBounds(30, 130, 100, 30);
		btnLogout.setBounds(30, 290, 100, 30);
		btnDeleteUser.setBounds(30, 330, 100, 30);
		
		fileScroll.setBounds(180, 10, 380, 350);
		
		this.setLayout(null);
		this.add(btnRemoveFile);
		this.add(btnAddFile);
		this.add(btnDownload);
		this.add(btnReport);
		this.add(btnLogout);
		this.add(btnDeleteUser);
		this.add(fileScroll);
	}

	private void initComponents() {
		// buttons in the left
		btnRemoveFile = new JButton(Constants.FILE_REMOVE);
		btnAddFile = new JButton(Constants.FILE_UPLOAD);
		btnDownload = new JButton(Constants.FILE_DOWNLOAD);
		btnReport = new JButton(Constants.FILE_REPORT);
		btnLogout = new JButton(Constants.USER_LOGOUT);
		btnDeleteUser = new JButton(Constants.USER_DELETE);
		
		// list in the right
		fileListModel = new FileListModel();
		fileList = new JList<String>(fileListModel);
		fileScroll = new JScrollPane();
		fileScroll.getViewport().add(fileList);
	}
	
	class MainPanelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == btnLogout){
				logoutRequest();
			} else if(obj == btnDeleteUser){
				deleteUserRequest();
			} else if(obj == btnRemoveFile){
				int selectedIndex = fileList.getSelectedIndex();
			} 
		}
	}
	
	class FileListModel extends AbstractListModel{
		

		@Override
		public int getSize() {
			return 300;
		}

		@Override
		public Object getElementAt(int index) {
			return "file" + index;
		}
		
	}
	
	class FileListSelectionListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			String stringValue = (String)fileList.getSelectedValue();
		}
	}

	public void logoutRequest() {
		try {
			UserFeedback userFeedback = userSystem.logout(ServiceManager.dsUser);
			if(userFeedback.isSuccess()){
				clientFrame.loadLoginPanel();
				clientFrame.popUpSuccess(Constants.SUCCESS_LOGOUT);
			} else{
				clientFrame.popupUserError(Constants.ERROR_USER_LOGOUT);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}


	public void deleteUserRequest() {
		try {
			UserFeedback userFeedback = userSystem.unregister(ServiceManager.dsUser);
			if(userFeedback.isSuccess()){
				clientFrame.loadLoginPanel();
				clientFrame.popUpSuccess(Constants.SUCCESS_UNREGISTER);
			} else{
				clientFrame.popupUserError(Constants.ERROR_USER_UNREGISTER);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}