package global.sesoc.team.vo;

public class AgeCategory {

	private int ten; 		// 10대
	private int twenty;		// 20대
	private int thirty;		// 30대
	private int forty;		// 40대
	private int fifty;		// 50대
	private int others;		// 그 외
	private int boardNum;	// 게시판 번호

	public AgeCategory() {
		super();
	}

	public AgeCategory(int ten, int twenty, int thirty, int forty, int fifty, int others, int boardNum) {
		super();
		this.ten = ten;
		this.twenty = twenty;
		this.thirty = thirty;
		this.forty = forty;
		this.fifty = fifty;
		this.others = others;
		this.boardNum = boardNum;
	}

	public int getTen() {
		return ten;
	}

	public void setTen(int ten) {
		this.ten = ten;
	}

	public int getTwenty() {
		return twenty;
	}

	public void setTwenty(int twenty) {
		this.twenty = twenty;
	}

	public int getThirty() {
		return thirty;
	}

	public void setThirty(int thirty) {
		this.thirty = thirty;
	}

	public int getForty() {
		return forty;
	}

	public void setForty(int forty) {
		this.forty = forty;
	}

	public int getFifty() {
		return fifty;
	}

	public void setFifty(int fifty) {
		this.fifty = fifty;
	}

	public int getOthers() {
		return others;
	}

	public void setOthers(int others) {
		this.others = others;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	@Override
	public String toString() {
		return "AgeCategory [ten=" + ten + ", twenty=" + twenty + ", thirty=" + thirty + ", forty=" + forty + ", fifty="
				+ fifty + ", others=" + others + ", boardNum=" + boardNum + "]";
	}


}
