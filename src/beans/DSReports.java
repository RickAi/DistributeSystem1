package beans;

import java.io.Serializable;
import java.util.List;


public class DSReports implements Serializable{
	
	private List<DSReport> reports;

	public List<DSReport> getReports() {
		return reports;
	}

	public void setReports(List<DSReport> reports) {
		this.reports = reports;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (DSReport report : reports) {
			builder.append(report + "\n");
		}
		return builder.toString();
	}
}
