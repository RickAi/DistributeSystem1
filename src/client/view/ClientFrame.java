package client.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import beans.DSUser;

import managers.ServiceManager;

import utils.Constants;

public class ClientFrame extends JFrame {

	// panels
	private LoginPanel loginPanel;
	private RegisterPanel registerPanel;
	private MainPanel mainPanel;
	private StatisticPanel reportPanel;

	public ClientFrame() {
		super(Constants.CLIENT_NAME);

		initService();
		initPanels();
		initFrame();
	}

	private void initService() {
		ServiceManager.clientFrame = this;
	}

	public void isServiceConnected() {
		if(ServiceManager.userSystem == null 
				|| ServiceManager.fileSystem == null 
				|| ServiceManager.statisticSystem == null){
			popUpConnectionError(Constants.ERROR_NO_CONNECTION);
		}
	}

	private void initPanels() {
		loginPanel = new LoginPanel();
		registerPanel = new RegisterPanel();
		mainPanel = new MainPanel();
		reportPanel = new StatisticPanel();
	}

	private void initFrame() {
		loadLoginPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void loadLoginPanel() {
		this.getContentPane().removeAll();
		this.getContentPane().add(loginPanel, BorderLayout.CENTER);
		repaintFrame();
	}

	public void loadRegisterPanel() {
		this.getContentPane().removeAll();
		this.getContentPane().add(registerPanel, BorderLayout.CENTER);
		repaintFrame();
	}

	public void loadMainPanel() {
		this.getContentPane().removeAll();
		this.getContentPane().add(mainPanel, BorderLayout.CENTER);
		repaintFrame();
	}

	public void loadReportPanel() {
		this.getContentPane().removeAll();
		this.setContentPane(reportPanel);
		repaintFrame();
	}

	private void repaintFrame() {
		this.getContentPane().validate();
		this.getContentPane().repaint();
	}

	public void popUpConnectionError(int errorType) {
		switch (errorType) {
		case Constants.ERROR_NO_CONNECTION:
			JOptionPane.showMessageDialog(null, "No connection!", "error",
					JOptionPane.ERROR_MESSAGE);
			break;
		default:
			break;
		}
	}

	public void popupUserError(int errorType) {
		switch (errorType) {
		case Constants.ERROR_USER_LOGIN:
			JOptionPane.showMessageDialog(null,
					"Name and password does not match!", "login error",
					JOptionPane.WARNING_MESSAGE);
			break;
		case Constants.ERROR_REGISTER_PASSWORD:
			JOptionPane.showMessageDialog(null,
					"Two passwords does not match!", "register error",
					JOptionPane.WARNING_MESSAGE);
			break;
		case Constants.ERROR_USER_REGISTER:
			JOptionPane.showMessageDialog(null,
					"Register failed, the name already exists!", "register error",
					JOptionPane.WARNING_MESSAGE);
			break;
		case Constants.ERROR_USER_LOGOUT:
			JOptionPane.showMessageDialog(null,
					"Logout failed!", "logout error",
					JOptionPane.WARNING_MESSAGE);
			break;
		case Constants.ERROR_USER_UNREGISTER:
			JOptionPane.showMessageDialog(null,
					"Unregister failed!", "unregister error",
					JOptionPane.WARNING_MESSAGE);
			break;
		default:
			break;
		}
	}

	public void popUpFileError(int errorType) {
		switch (errorType) {
		case Constants.ERROR_FILE_UPLOAD:
			JOptionPane.showMessageDialog(null, "Upload file failed!", "upload error",
					JOptionPane.ERROR_MESSAGE);
			break;
		case Constants.ERROR_FILE_NO_CONTENT:
			JOptionPane.showMessageDialog(null, "The uploaded file cannot be empty!", "upload error",
					JOptionPane.ERROR_MESSAGE);
			break;
		case Constants.ERROR_FILE_NO_SELECTED:
			JOptionPane.showMessageDialog(null, "No file has be selected!", "selection error",
					JOptionPane.ERROR_MESSAGE);
			break;
		default:
			break;
		}
	}

	public void popUpStatisticError(int errorType) {

	}
	
	public void popUpFileSuccess(int successType){
		switch (successType) {
		case Constants.SUCCESS_REGISTER:
			JOptionPane.showMessageDialog(null,"Register success!");
			break;
		case Constants.SUCCESS_UPLOAD_FILE:
			JOptionPane.showMessageDialog(null,"Upload file success!");
			break;
		case Constants.SUCCESS_LOGIN:
			JOptionPane.showMessageDialog(null,"Welcome!");
			break;
		case Constants.SUCCESS_LOGOUT:
			JOptionPane.showMessageDialog(null,"Logout success!");
			break;
		case Constants.SUCCESS_UNREGISTER:
			DSUser dsUser = ServiceManager.dsUser;
			JOptionPane.showMessageDialog(null,"Delete user sucess!\n\n- name:" + dsUser.getName()+"\n- password:" + dsUser.getPassword());
			break;
		default:
			break;
		}
	}
	
	public void popUpFileSuccess(int successType, String fileName){
		switch (successType) {
		case Constants.SUCCESS_FILE_DOWNLOAD:
			JOptionPane.showMessageDialog(null,"Download "+ fileName +" success!");
			break;
		case Constants.SUCCESS_FILE_REMOVE:
			JOptionPane.showMessageDialog(null,"Remove " + fileName + " success!");
			break;
		default:
			break;
		}
	}
	
	public void popUpFileError(int errorType, String fileName){
		switch (errorType) {
		case Constants.ERROR_FILE_DOWNLOAD:
			JOptionPane.showMessageDialog(null, "Download " + fileName + " failed!", "download error",
					JOptionPane.ERROR_MESSAGE);
			break;
		case Constants.ERROR_FILE_REMOVE:
			JOptionPane.showMessageDialog(null, "Remove " + fileName + " failed!", "remove error",
					JOptionPane.ERROR_MESSAGE);
			break;
		default:
			break;
		}
	}

}
