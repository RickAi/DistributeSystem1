package client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import interfaces.StatisticSystem;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import beans.DSStatistic;
import beans.feedbacks.StatisticFeedback;

import utils.Constants;

import managers.ServiceManager;

public class StatisticPanel extends JPanel {
	
	private JButton btnBack;
	private JTextArea taReport;
	private JScrollPane reportScroll;
	
	private List<DSStatistic> statistics;
	private StatisticSystem statisticSystem;
	private ClientFrame clientFrame;
	
	public StatisticPanel() {
		initServices();
		initComponents();
		initDatas();
		initLocations();
		initListeners();
	}

	public void initDatas() {
		try {
			StatisticFeedback statisticFeedback = statisticSystem.getFileUsage();
			statistics = statisticFeedback.getDsStatistics();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		StringBuilder sb = new StringBuilder();
		for (DSStatistic dsStatistic : statistics) {
			sb.append(dsStatistic + "\n");
		}
		taReport.setText(sb.toString());
	}

	private void initListeners() {
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clientFrame.loadMainPanel();
			}
		});
	}

	private void initLocations() {
		btnBack.setBounds(50, 20, 100, 30);
		reportScroll.getViewport().add(taReport);
		reportScroll.setBounds(50, 50, 500, 300);
		
		
		this.setLayout(null);
		this.add(btnBack);
		this.add(reportScroll);
	}

	private void initComponents() {
		btnBack = new JButton(Constants.BACK);
		taReport = new JTextArea();
		reportScroll = new JScrollPane();
		taReport.setEditable(false);
	}

	private void initServices() {
		statisticSystem = ServiceManager.statisticSystem;
		clientFrame = ServiceManager.clientFrame;
	}

}
