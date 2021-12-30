package emailList;

import java.util.ArrayList;

public class DaoTest {
	public static void main(String[] args) {
		EmailListDao dao = new EmailListDao();
		ArrayList<EmailListVo> list = dao.viewEmailList();
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			String last_name = list.get(i).getLast_name();
			String first_name = list.get(i).getFirst_name();
			String email = list.get(i).getEmail();
			System.out.println("last_name: " + last_name);
			System.out.println("first_name: " + first_name);
			System.out.println("email: " + email);
		}
	}
}
