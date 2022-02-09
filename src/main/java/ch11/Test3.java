package ch11;

public class Test3 {

	public static void main(String[] args) {
		String salary = "";
		
		//부장
		for(int i=0; i<12; i++) {			
			salary=Integer.toString((int)(Math.random()*684)+7548);
			salary+="0000";
			System.out.println(salary);
		}
		
		//차장
		for(int i=0; i<24; i++) {			
			salary=Integer.toString((int)(Math.random()*835)+6332);
			salary+="0000";
			System.out.println(salary);
		}
		
		//과장
		for(int i=0; i<36; i++) {			
			salary=Integer.toString((int)(Math.random()*646)+5360);
			salary+="0000";
			System.out.println(salary);
		}
		
		//대리
		for(int i=0; i<36; i++) {			
			salary=Integer.toString((int)(Math.random()*700)+4359);
			salary+="0000";
			System.out.println(salary);
		}
		
		//주임
		for(int i=0; i<48; i++) {			
			salary=Integer.toString((int)(Math.random()*411)+3728);
			salary+="0000";
			System.out.println(salary);
		}
		
		//사원
		for(int i=0; i<48; i++) {			
			salary=Integer.toString((int)(Math.random()*1240)+2311);
			salary+="0000";
			System.out.println(salary);
		}
	}
}
