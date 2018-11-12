package global.sesoc.team.vo;

public class Table {
	private String seq;
	private String message;
	private String userId;
	private String roomnum;
	private String mdate;
	
	public Table() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Table(String seq, String message, String userId, String roomnum, String mdate) {
		super();
		this.seq = seq;
		this.message = message;
		this.userId = userId;
		this.roomnum = roomnum;
		this.mdate = mdate;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getuserId() {
		return userId;
	}

	public void setuserId(String userId) {
		this.userId = userId;
	}

	public String getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	@Override
	public String toString() {
		return userId+" : "+message;
	}	
}
