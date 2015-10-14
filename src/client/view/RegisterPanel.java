package client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import interfaces.UserSystem;

import javax.imageio.spi.RegisterableService;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import beans.DSUser;
import beans.feedbacks.UserFeedback;

import managers.ServiceManager;

import utils.Constants;

public class RegisterPanel extends JPanel {
	
	private JTextField tfName;
	private JTextField tfPassword;
	private JTextField tfPassword2;
	private JButton btnRegister;
	
	private UserSystem userSystem;
	private ClientFrame clientFrame;
	
	public RegisterPanel() {
		initServices();
		initComponents();
		initLocations();
		initListeners();
	}

	private void initListeners() {
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!tfPassword.getText().equals(tfPassword2.getText())){
					clientFrame.popupUserError(Constants.ERROR_REGISTER_PASSWORD);
					return ;
				}
				
				DSUser dsUser = new DSUser(tfName.getText(), tfPassword.getText());
				try {
					UserFeedback userFeedback = userSystem.register(dsUser);
					if(userFeedback.isSuccess()){
						clearInputs();
						clientFrame.loadLoginPanel();
						clientFrame.popUpFileSuccess(Constants.SUCCESS_REGISTER);
					} else{
						clientFrame.popupUserError(Constants.ERROR_USER_REGISTER);
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
					
			}
		});
	}

	private void initLocations() {
		tfName.setBounds(150, 150, 300, 30);
		tfPassword.setBounds(150, 200, 300, 30);
		tfPassword2.setBounds(150, 250, 300, 30);
		btnRegister.setBounds(190, 300, 200, 30);
		
		this.setLayout(null);
		this.add(tfName);
		this.add(tfPassword);
		this.add(tfPassword2);
		this.add(btnRegister);
	}

	private void initComponents() {
		tfName = new JTextField();
		tfPassword = new JTextField();
		tfPassword2 = new JTextField();
		btnRegister = new JButton(Constants.REGISTER_BUTTON);
	}

	private void initServices() {
		clientFrame = ServiceManager.clientFrame;
		userSystem = ServiceManager.userSystem;
	}
	
	public void clearInputs(){
		tfName.setText(Constants.EMPTY_STRING);
		tfPassword.setText(Constants.EMPTY_STRING);
		tfPassword2.setText(Constants.EMPTY_STRING);
	}

}
