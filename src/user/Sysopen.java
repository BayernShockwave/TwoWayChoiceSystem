package user;
import java.util.Date;
public class Sysopen {
	private String tid;
	private Date begin,end;
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTid() {
		return tid;
	}
	public void setBegin(Date begin) {
		this.begin=begin;
	}
	public Date getBegin() {
		return begin;
	}
	public void setEnd(Date end) {
		this.end=end;
	}
	public Date getEnd() {
		return end;
	}
}