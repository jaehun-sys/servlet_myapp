package guestbook;

import java.util.ArrayList;

public interface GuestBookDao {
	public ArrayList<GuestBookVo> select();
	public boolean insert(GuestBookVo vo);
	public boolean update(GuestBookVo vo);
	public boolean delete(int num, String pwd);
}
