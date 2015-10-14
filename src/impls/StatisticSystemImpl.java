package impls;

import managers.FileManager;
import managers.StatisticManager;
import beans.DSStatistics;
import beans.feedbacks.Feedback;
import beans.feedbacks.StatisticFeedback;
import interfaces.StatisticSystem;

public class StatisticSystemImpl implements StatisticSystem {

	public StatisticFeedback getFileUsage() {
		DSStatistics dsStatistics = StatisticManager.getReportsFromFile();
		StatisticFeedback statisticFeedback = new StatisticFeedback(Feedback.RESULT_TRUE);
		statisticFeedback.setDsStatistics(dsStatistics.getStatistics());
		return statisticFeedback;
	}

	public StatisticFeedback getNumberOfFile() {
		int numberOfFiles = FileManager.getNumberOfFiles();
		StatisticFeedback statisticFeedback = new StatisticFeedback(Feedback.RESULT_TRUE);
		statisticFeedback.setNumberOfFiles(numberOfFiles);
		return statisticFeedback;
	}

}
