package beans.feedbacks;

import java.io.Serializable;

public class Feedback implements Serializable {
	public static final int RESULT_SUCCESS = 0;
	public static final int RESULT_FAIL = 1;

	private int mResult;
	private String mResultMessage;

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
}
