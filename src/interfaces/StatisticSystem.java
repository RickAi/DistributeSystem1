package interfaces;

import beans.feedbacks.StatisticFeedback;

public interface StatisticSystem {
	
	// file usage
	public StatisticFeedback getFileUsage();
	
	// number of file
	public StatisticFeedback getNumberOfFile();
	
}
