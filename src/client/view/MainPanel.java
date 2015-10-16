package client.view;

import interfaces.FileSystem;
import interfaces.UserSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import managers.ServiceManager;
import utils.Constants;
import beans.feedbacks.FileFeedback;
import beans.feedbacks.UserFeedback;

public class MainPanel extends JPanel {

	// all the widgets
	private JButton btnRemoveFile;
	private JButton btnDownload;
	private JButton btnAddFile;
	private JButton btnReport;
	private JButton btnLogout;
	private JButton btnDeleteUser;

	private JList<String> fileList;
	private List<String> fileNames;
	private FileListModel fileListModel;
	private JScrollPane fileScroll;

	private UserSystem userSystem;
	private FileSystem fileSystem;
	private ClientFrame clientFrame;

	// initialize all the components the situation
	public MainPanel() {
		initServices();
		initDatas();
		initComponents();
		initLocations();
		initListeners();
	}
	
	// initialize all the data of the file list
	private void initDatas() {
		try {
			FileFeedback fileFeedback = fileSystem.availableFiles();
			if (fileFeedback.isSuccess()) {
				fileNames = fileFeedback.getFileNames();
			} else {
				fileNames = new ArrayList<String>();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	// initialize all the listeners for the main panel
	private void initListeners() {
		MainPanelListener mainPanelListener = new MainPanelListener();
		btnLogout.addActionListener(mainPanelListener);
		btnDeleteUser.addActionListener(mainPanelListener);
		btnAddFile.addActionListener(mainPanelListener);
		btnDownload.addActionListener(mainPanelListener);
		btnRemoveFile.addActionListener(mainPanelListener);
		btnReport.addActionListener(mainPanelListener);
	}

	// initialize all the services
	private void initServices() {
		userSystem = ServiceManager.userSystem;
		fileSystem = ServiceManager.fileSystem;
		clientFrame = ServiceManager.clientFrame;
	}

	// initialize all the locations of the widgets
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

	// initialize all the components
	private void initComponents() {
		// buttons in the left
		btnRemoveFile = new JButton(Constants.FILE_REMOVE);
		btnAddFile = new JButton(Constants.FILE_UPLOAD);
		btnDownload = new JButton(Constants.FILE_DOWNLOAD);
		btnReport = new JButton(Constants.FILE_REPORT);
		btnLogout = new JButton(Constants.USER_LOGOUT);
		btnDeleteUser = new JButton(Constants.USER_DELETE);

		// list in the right
		fileListModel = new FileListModel(fileNames);
		fileList = new JList<String>(fileListModel);
		fileScroll = new JScrollPane();
		fileScroll.getViewport().add(fileList);
	}

	/**
	 * 
	 * @author CIR
	 * 
	 * MainPanelListener is the listener for the MainPanel
	 *
	 */
	class MainPanelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();

			if (obj == btnLogout) {
				logoutRequest();
			} else if (obj == btnDeleteUser) {
				deleteUserRequest();
			} else if (obj == btnRemoveFile) {
				removeFile();
			} else if (obj == btnAddFile) {
				uploadFile();
			} else if (obj == btnDownload) {
				downloadFile();
			} else if(obj == btnReport){
				clientFrame.loadReportPanel();
			}
		}
	}

	/**
	 * 
	 * @author CIR
	 * 
	 * FileListModel is the model for the main panel list
	 *
	 */
	class FileListModel extends AbstractListModel {
		private List<String> names;

		public FileListModel(List<String> names) {
			this.names = names;
		}

		@Override
		public int getSize() {
			return names.size();
		}

		@Override
		public Object getElementAt(int index) {
			return names.get(index);
		}

	}

	// the client send logout request
	public void logoutRequest() {
		try {
			UserFeedback userFeedback = userSystem
					.logout(ServiceManager.dsUser);
			if (userFeedback.isSuccess()) {
				clientFrame.loadLoginPanel();
				clientFrame.popUpFileSuccess(Constants.SUCCESS_LOGOUT);
			} else {
				clientFrame.popupUserError(Constants.ERROR_USER_LOGOUT);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	// the client send a remove file request
	public void removeFile() {
		String selectedFileName = fileList.getSelectedValue();
		if (selectedFileName == null) {
			clientFrame.popUpFileError(Constants.ERROR_FILE_NO_SELECTED);
			return;
		}
		
		
		try {
			FileFeedback fileFeedback = fileSystem.removeFile(selectedFileName, ServiceManager.dsUser);
			if(fileFeedback.isSuccess()){
				refreshFileList();
				clientFrame.popUpFileSuccess(Constants.SUCCESS_FILE_REMOVE, selectedFileName);
			} else{
				clientFrame.popUpFileError(Constants.ERROR_FILE_REMOVE, selectedFileName);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	// the client send a delete user request
	public void deleteUserRequest() {
		try {
			UserFeedback userFeedback = userSystem
					.unregister(ServiceManager.dsUser);
			if (userFeedback.isSuccess()) {
				clientFrame.loadLoginPanel();
				clientFrame.popUpFileSuccess(Constants.SUCCESS_UNREGISTER);
			} else {
				clientFrame.popupUserError(Constants.ERROR_USER_UNREGISTER);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	// the client send a upload file request
	public void uploadFile() {
		JFileChooser fc = createFileChooser();

		File uploadedFile = fc.getSelectedFile();
		if (uploadedFile == null) {
			return;
		} else if (uploadedFile.length() == 0) {
			clientFrame.popUpFileError(Constants.ERROR_FILE_NO_CONTENT);
			return;
		}

		try {
			FileFeedback fileFeedback = fileSystem.uploadFile(uploadedFile, ServiceManager.dsUser);
			if (fileFeedback.isSuccess()) {
				refreshFileList();
				clientFrame.popUpFileSuccess(Constants.SUCCESS_UPLOAD_FILE);
			} else {
				clientFrame.popUpFileError(Constants.ERROR_FILE_UPLOAD);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			clientFrame.popUpFileError(Constants.ERROR_FILE_UPLOAD);
		}
	}

	// the client send a download file request
	public void downloadFile() {
		String selectedFileName = fileList.getSelectedValue();
		if (selectedFileName == null) {
			clientFrame.popUpFileError(Constants.ERROR_FILE_NO_SELECTED);
			return;
		}
		
		try {
			FileFeedback fileFeedback = fileSystem.downloadFile(selectedFileName, ServiceManager.dsUser);
			File file = fileFeedback.getFile();
			if(fileFeedback.isSuccess() && saveFile(file)){
				clientFrame.popUpFileSuccess(Constants.SUCCESS_FILE_DOWNLOAD, selectedFileName);
			} else{
				clientFrame.popUpFileError(Constants.ERROR_FILE_REMOVE, selectedFileName);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	// the client send a save file request
	private boolean saveFile(File file) {
		File savedFile = new File(Constants.FILE_DOWNLOAD_DIR + "/" + file.getName());
		FileInputStream inputStream;
		FileOutputStream outputStream;
		
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			
			inputStream = new FileInputStream(file);
			outputStream = new FileOutputStream(savedFile);
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = inputStream.read(buf)) > 0) {
				outputStream.write(buf, 0, len);
			}
			if (inputStream != null)
				inputStream.close();
			if (outputStream != null)
				outputStream.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			clientFrame.popUpFileError(Constants.ERROR_FILE_DOWNLOAD, file.getName());
		}
		return false;
	}

	// create a new file chooser for the client
	private JFileChooser createFileChooser() {
		JFileChooser fc = new JFileChooser("");
		fc.setMultiSelectionEnabled(false);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setFileHidingEnabled(true);
		fc.setAcceptAllFileFilterUsed(false);
		fc.showOpenDialog(this);
		return fc;
	}
	
	// refresh the JList of the file
	private void refreshFileList(){
		initDatas();
		fileListModel = new FileListModel(fileNames);
		fileList.setModel(fileListModel);
		fileScroll.revalidate();
		fileScroll.repaint();
	}

}
