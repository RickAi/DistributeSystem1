package beans.feedbacks;

import java.io.Serializable;
import java.util.List;

import beans.DSStatistic;
import beans.DSStatistics;

public class StatisticFeedback extends Feedback implements Serializable {
	
	public static final String FILE_USAGE = "file_usage";
	
	private List<DSStatistic> dsStatistics;
	private int numberOfFiles;
	
	
	public StatisticFeedback(int mResult) {
		super(mResult);
	}

	public List<DSStatistic> getDsStatistics() {
		return dsStatistics;
	}

	public void setDsStatistics(List<DSStatistic> dsStatistics) {
		this.dsStatistics = dsStatistics;
	}

	public int getNumberOfFiles() {
		return numberOfFiles;
	}

	public void setNumberOfFiles(int numberOfFiles) {
		this.numberOfFiles = numberOfFiles;
	}

}
