package user;
public class ColAdmin {
	private String userid,name,password,college,locked;
	public void setUserid(String userid) {
		this.userid=userid;
	}
	public String getUserid() {
		return userid;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	public void setCollege(String college) {
		this.college=college;
	}
	public String getCollege() {
		return college;
	}
	public void setLocked(String locked) {
		this.locked=locked;
	}
	public String getLocked() {
		return locked;
	}
}