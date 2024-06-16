package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTeller {
//	public static void main(String[] args) {
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//http://localhost:8080/ch2/getYoil?year=2021&month=10&day=1
		
		//1.입력
		//String year = args[0]; //로컬 프로그램 이용해 출력
		//String month = args[1];
		//String day = args[2];
		
		String year = request.getParameter("year"); //원격 프로그램으로 출력
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		//2.직업
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 요일 알아내기. 요일이 숫자로 남옴. 1=일요일, 2=월요일..
		char yoil = " 일월화수목금토".charAt(dayOfWeek); // 숫자를 문자로 바꿔주는 것. 1 => 일요일...
		
		//3.출력
//		System.out.println(year + "년 " + month + "월 " + day + "일은 "); //콘솔에 출력
//		System.out.println(yoil + "요일입니다.");
		
		//브라우저에 출력
		response.setContentType("text/html"); //출력하기전에 출력할 내용의 타입을 써줘야함
		//내가 보내는 내용이 텍스트인지 바이너리인지 모르기때문에 텍스틑를 보낸다는걸 알려주고
		response.setCharacterEncoding("utf-8"); //텍스트의 인코딩이 뭔지 알려줘야 제대로 보여질 수 있음. 그래야 브라우저가 제대로 해석 할 수 있음. 없으면 한글 깨짐
		PrintWriter out = response.getWriter(); // response객체에서 브라우저로의 출력 스트림을 얻는다.
		out.println(year + "년 " + month + "월 " + day + "일은 "); //콘솔에 출력
		out.println(yoil + "요일입니다.");
		
	}
	

}
