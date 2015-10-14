package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class DSStatistics implements Serializable{
	
	private List<DSStatistic> statistics = new ArrayList<DSStatistic>();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (DSStatistic statistic : getStatistics()) {
			builder.append(statistic + "\n");
		}
		return builder.toString();
	}

	public List<DSStatistic> getStatistics() {
		return statistics;
	}

	public void setStatistics(List<DSStatistic> statistics) {
		this.statistics = statistics;
	}
}
