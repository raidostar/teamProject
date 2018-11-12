package global.sesoc.team.vo;

public class ContestReply {

	private int replyNum;		// 리플 넘버
	private String userId;		// 유저 아이디

	public ContestReply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContestReply(int replyNum, String userId) {
		super();
		this.replyNum = replyNum;
		this.userId = userId;
	}

	public int getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "contestreply [replyNum=" + replyNum + "]";
	}

}
