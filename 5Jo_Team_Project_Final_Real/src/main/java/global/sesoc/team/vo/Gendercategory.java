package global.sesoc.team.vo;

public class Gendercategory {
	private String male;		//남자
	private String female;		//여자
	private int boardNum;		//게시판 번호

	public Gendercategory() {
		super();
	}

	public Gendercategory(String male, String female, int boardNum) {
		super();
		this.male = male;
		this.female = female;
		this.boardNum = boardNum;
	}

	public String getMale() {
		return male;
	}

	public void setMale(String male) {
		this.male = male;
	}

	public String getFemale() {
		return female;
	}

	public void setFemale(String female) {
		this.female = female;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	@Override
	public String toString() {
		return "gendercategory [male=" + male + ", female=" + female + ", boardNum=" + boardNum + "]";
	}

}
