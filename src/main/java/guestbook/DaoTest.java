package guestbook;

import java.util.ArrayList;

public class DaoTest {
	public static void main(String[] args) {
		GuestBookDao dao = new GuestBookImpl();
		
		//select
		ArrayList<GuestBookVo> list = dao.select();
		System.out.println(list.toString());
		
		//insert
		GuestBookVo vo = new GuestBookVo();
		vo.setName("테스트 책이름");
		vo.setPassword("테스트 비번");
		vo.setContent("테스트 책내용");
		dao.insert(vo);
		System.out.println(dao.select().toString());
		
	}

}
