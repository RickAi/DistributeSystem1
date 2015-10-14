package beans.feedbacks;

import java.io.Serializable;

import beans.DSReport;

public class StatisticFeedback extends Feedback implements Serializable {
	
	public static final String FILE_USAGE = "file_usage";
	
	private DSReport report;
	
	public StatisticFeedback(int mResult) {
		super(mResult);
	}

	public DSReport getReport() {
		return report;
	}

	public void setReport(DSReport report) {
		this.report = report;
	}

}
