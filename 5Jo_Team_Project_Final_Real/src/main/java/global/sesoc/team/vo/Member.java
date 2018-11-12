package global.sesoc.team.vo;

public class Member {

	private String userName;		//유저 이름
	private String userPwd;			//비밀번호
	private String userId;			//아이디
	private String gender;			//성별
	private String birth;			//생일
	private String address;			//주소
	private String emailAccount;	//이메일 주소
	private String emailDomain;		//이메일 도메인
	private char verify;			//검증
	private int point;				//포인트
	private String authority;		//??
	private int userNum;			//유저번호

	public Member() {
		super();
	}

	public Member(String userName, String userPwd, String userId, String gender, String birth, String address,
			String emailAccount, String emailDomain, char verify, int point, String authority, int userNum) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.userId = userId;
		this.gender = gender;
		this.birth = birth;
		this.address = address;
		this.emailAccount = emailAccount;
		this.emailDomain = emailDomain;
		this.verify = verify;
		this.point = point;
		this.authority = authority;
		this.userNum = userNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailAccount() {
		return emailAccount;
	}

	public void setEmailAccount(String emailAccount) {
		this.emailAccount = emailAccount;
	}

	public String getEmailDomain() {
		return emailDomain;
	}

	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}

	public char getVerify() {
		return verify;
	}

	public void setVerify(char verify) {
		this.verify = verify;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	@Override
	public String toString() {
		return "Member [userName=" + userName + ", userPwd=" + userPwd + ", userId=" + userId + ", gender=" + gender
				+ ", birth=" + birth + ", address=" + address + ", emailAccount=" + emailAccount + ", emailDomain="
				+ emailDomain + ", verify=" + verify + ", point=" + point + ", authority=" + authority + ", userNum="
				+ userNum + "]";
	}

}
