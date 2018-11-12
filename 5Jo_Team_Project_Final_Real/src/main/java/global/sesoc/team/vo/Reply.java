package global.sesoc.team.vo;

public class Reply {

	private int replyNum;
	private String replyText;
	private String userId;

	public Reply() {
		super();
	}

	public Reply(int replyNum, String replyText, String userId) {
		super();
		this.replyNum = replyNum;
		this.replyText = replyText;
		this.userId = userId;
	}

	public int getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}

	public String getReplyText() {
		return replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Reply [replyNum=" + replyNum + ", replyText=" + replyText + ", userId=" + userId + "]";
	}

}
