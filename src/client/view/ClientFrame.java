package client.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import managers.ServiceManager;

import utils.Constants;

public class ClientFrame extends JFrame {

	// panels
	private LoginPanel loginPanel;
	private RegisterPanel registerPanel;
	private MainPanel mainPanel;
	private ReportPanel reportPanel;

	public ClientFrame() {
		super(Constants.CLIENT_NAME);
		
		ServiceManager.clientFrame = this;
		initPanels();
		initFrame();
	}

	private void initPanels() {
		loginPanel = new LoginPanel();
		registerPanel = new RegisterPanel();
		mainPanel = new MainPanel();
		reportPanel = new ReportPanel();
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
	
	private void repaintFrame(){
		this.getContentPane().validate();
		this.getContentPane().repaint(); 
	}

}
