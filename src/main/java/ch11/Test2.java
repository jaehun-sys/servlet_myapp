package ch11;

import java.io.*;

public class Test2 {
	public static void main(String[] ar) throws IOException {
		BufferedReader in = new BufferedReader(
new InputStreamReader(System.in));
		int year = 0, month = 0, day = 0, area = 0, sex = 0;
		String jumin = "";
		char[] ju = new char[12];
		
		for(int j=0; j<200; j++) {
			do {
				//System.out.print("태어난 연도를 입력해주세요 = ");
				//year = Integer.parseInt(in.readLine());
				year = (int)(Math.random()*43)+1960;
			}while(year < 1800 || year > 2099);
			do {
				//System.out.print("태어난 월을 입력해주세요 = ");
				month = (int)(Math.random()*12)+1;
			}while(month < 1 || month > 12);
			do {
				//System.out.print("태어난 일을 입력해주세요= ");
				day = (int)(Math.random()*31)+1;
			}while(day < 1 || day > 31);//날짜는 정확히 비교 하지 않았음.
			do {
				//System.out.print("태어난 지역(0:서울1:경기,인천2:강원도3:충정북도4:충청남도5:전라북도6:전라남도7:경상북도8:경상남도 9:제주도)=");
				area = (int)(Math.random()*9);
			}while(area < 0 || area > 9);
			do {
				//System.out.print("성별을 입력해주세요(0:남성, 1:여성) = ");
				sex = (int)(Math.random()*2);
			}while(sex != 0 && sex != 1);
			
			int yy = year - (int)(year / 100) * 100;
			if(yy < 10){
				jumin = "0"+ yy;
			}else {
				jumin = "" + yy;
			}
			//jumin = "" + (year - (int)(year / 100) * 100);
			if(month < 10) jumin += "0";
			jumin += month;
			if(day < 10) jumin += "0";
			jumin += day;
			jumin += "-";
			switch((int)(year / 100)) {
			case 18: jumin += sex == 0 ? "9" : "0"; break;
			case 19: jumin += sex == 0 ? "1" : "2"; break;
			case 20: jumin += sex == 0 ? "3" : "4"; 
			}
			jumin += area;
			jumin += "0000";
			
			for(int i = 0; i < ju.length; ++i) {
				ju[i] = jumin.charAt(i);
			}
			
			int hap = 0;
			float temp = 0.0f;
			float temp1 = 0.0f;
			int cre = 2;
			for(int i = 0; i < ju.length; ++i) {
				hap += ju[i] * cre++;
				if(cre == 10) cre = 2;
			}
			temp = (int)(hap / 10.0f) * 10.0f + 10.0f - hap;
			temp1 = temp - (int)(temp / 10.0f) * 10.0f;
			jumin += (int)temp1;
			
			//System.out.println();
			System.out.println(jumin);
		}
		
		
	}
}


