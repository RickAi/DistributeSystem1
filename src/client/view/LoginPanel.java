package client.view;

import interfaces.UserSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import managers.ServiceManager;
import utils.Constants;
import beans.DSUser;
import beans.feedbacks.UserFeedback;

public class LoginPanel extends JPanel {
	
	/**
	 * 
	 * LoginPanel is the client view to login
	 */
	
	// components
	private JTextField tfName;
	private JTextField tfPassword;
	private JButton btnLogin;
	private JButton btnRegister;
	
	// services
	private UserSystem userSystem;
	private ClientFrame clientFrame;
	
	
	// initialize all the data and situation
	public LoginPanel() {
		initServices();
		initComponents();
		initLocations();
		initListeners();
	}

	// initialize the services
	private void initServices() {
		clientFrame = ServiceManager.clientFrame;
		userSystem = ServiceManager.userSystem;
	}

	// initialize all the listeners
	private void initListeners() {
		LoginPanelListener listener = new LoginPanelListener();
		btnLogin.addActionListener(listener);
		btnRegister.addActionListener(listener);
	}
	
	// initialize all the widgets' locations
	private void initLocations() {
		tfName.setBounds(150, 170, 300, 30);
		tfPassword.setBounds(150, 220, 300, 30);
		btnLogin.setBounds(180, 270, 100, 30);
		btnRegister.setBounds(320, 270, 100, 30);
		
		this.setLayout(null);
		this.add(tfName);
		this.add(tfPassword);
		this.add(btnLogin);
		this.add(btnRegister);
	}

	// initialize all the instance of components
	private void initComponents() {
		tfName = new JTextField();
		tfPassword = new JTextField();
		btnLogin = new JButton(Constants.LOGIN_BUTTON);
		btnRegister = new JButton(Constants.REGISTER_BUTTON);
	}
	
	/**
	 * 
	 * @author CIR
	 * 
	 * LoginPanelListener is the listener for the LoginPanel
	 *
	 */
	class LoginPanelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj == btnLogin){
				loginRequest();
			} else if(obj == btnRegister){
				registerRequest();
			}
		}
	}

	// the client send a login request
	public void loginRequest() {
		DSUser user = new DSUser(tfName.getText(), tfPassword.getText());
		try {
			UserFeedback userFeedback = userSystem.login(user);
			if(userFeedback.isSuccess()){
				ServiceManager.dsUser = user;
				clearInputs();
				clientFrame.loadMainPanel();
				clientFrame.popUpFileSuccess(Constants.SUCCESS_LOGIN);
			} else{
				clientFrame.popupUserError(Constants.ERROR_USER_LOGIN);
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	// the client send a register request
	public void registerRequest() {
		clientFrame.loadRegisterPanel();
	}
	
	// clear all the inputs of login and register JTextField
	public void clearInputs(){
		tfName.setText(Constants.EMPTY_STRING);
		tfPassword.setText(Constants.EMPTY_STRING);
	}
	

}
