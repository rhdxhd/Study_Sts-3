package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTeller {
//	public static void main(String[] args) {
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//http://localhost:8080/ch2/getYoil?year=2021&month=10&day=1
		
		//1.�Է�
		//String year = args[0]; //���� ���α׷� �̿��� ���
		//String month = args[1];
		//String day = args[2];
		
		String year = request.getParameter("year"); //���� ���α׷����� ���
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		//2.����
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // ���� �˾Ƴ���. ������ ���ڷ� ����. 1=�Ͽ���, 2=������..
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek); // ���ڸ� ���ڷ� �ٲ��ִ� ��. 1 => �Ͽ���...
		
		//3.���
//		System.out.println(year + "�� " + month + "�� " + day + "���� "); //�ֿܼ� ���
//		System.out.println(yoil + "�����Դϴ�.");
		
		//�������� ���
		response.setContentType("text/html"); //����ϱ����� ����� ������ Ÿ���� �������
		//���� ������ ������ �ؽ�Ʈ���� ���̳ʸ����� �𸣱⶧���� �ؽ��z�� �����ٴ°� �˷��ְ�
		response.setCharacterEncoding("utf-8"); //�ؽ�Ʈ�� ���ڵ��� ���� �˷���� ����� ������ �� ����. �׷��� �������� ����� �ؼ� �� �� ����. ������ �ѱ� ����
		PrintWriter out = response.getWriter(); // response��ü���� ���������� ��� ��Ʈ���� ��´�.
		out.println(year + "�� " + month + "�� " + day + "���� "); //�ֿܼ� ���
		out.println(yoil + "�����Դϴ�.");
		
	}
	

}
