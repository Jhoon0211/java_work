package model_p;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GalleryDTO {
	String title, pname, pw, upfile, content;
	Date reg_date;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E) HH:mm");
	int id, cnt, gid;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUpfile() {
		return upfile;
	}
	public void setUpfile(String upfile) {
		this.upfile = upfile;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	
	@Override
	public String toString() {
		return "GalleryDTO [title=" + title + ", pname=" + pname + ", pw=" + pw + ", upfile=" + upfile + ", content="
				+ content + ", reg_date=" + reg_date + ", id=" + id + ", cnt=" + cnt + ", gid=" + gid
				+ "]";
	}
	
}
