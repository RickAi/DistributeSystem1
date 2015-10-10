package beans.feedbacks;

import java.io.Serializable;

public class Feedback implements Serializable {
	public static final int RESULT_TRUE = 0;
	public static final int RESULT_FALSE = 1;

	private int mResult;
	private String mResultMessage;
	
	public Feedback(int mResult) {
		super();
		this.mResult = mResult;
	}

	public int getResult() {
		return mResult;
	}

	public void setResult(int result) {
		mResult = result;
	}

	public String getResultMessage() {
		return mResultMessage;
	}

	public void setResultMessage(String resultMessage) {
		mResultMessage = resultMessage;
	}
	
	@Override
	public String toString() {
		return (mResult == RESULT_TRUE)?"true":"false";
	}
}
