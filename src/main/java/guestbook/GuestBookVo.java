package guestbook;

public class GuestBookVo {
	private int bookno;
	private String name;
	private String password;
	private String content;
	private String regdate;
	
	public int getBookno() {
		return bookno;
	}
	public void setBookno(int bookno) {
		this.bookno = bookno;
	}
	public String getName() {
		return name;
	}
	public void setName(String bookname) {
		this.name = bookname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "GuestBookVo [bookno=" + bookno + ", name=" + name + ", password=" + password + ", content="
				+ content + ", regdate=" + regdate + "]";
	}
}
