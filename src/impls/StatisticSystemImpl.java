package impls;

import managers.FileManager;
import managers.StatisticManager;
import beans.DSStatistics;
import beans.feedbacks.Feedback;
import beans.feedbacks.StatisticFeedback;
import interfaces.StatisticSystem;

public class StatisticSystemImpl implements StatisticSystem {
	
	/**
	 * 
	 * StatisticSystemImpl is the implementation of StatisticSystem service
	 */

	// get the files' report from the DB and send it back to client
	public StatisticFeedback getFileUsage() {
		DSStatistics dsStatistics = StatisticManager.getReportsFromFile();
		StatisticFeedback statisticFeedback = new StatisticFeedback(Feedback.RESULT_TRUE);
		statisticFeedback.setDsStatistics(dsStatistics.getStatistics());
		return statisticFeedback;
	}

	// get the files' number from the DB and send it back to client
	public StatisticFeedback getNumberOfFile() {
		int numberOfFiles = FileManager.getNumberOfFiles();
		StatisticFeedback statisticFeedback = new StatisticFeedback(Feedback.RESULT_TRUE);
		statisticFeedback.setNumberOfFiles(numberOfFiles);
		return statisticFeedback;
	}

}
