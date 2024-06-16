package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. ���� ȣ�Ⱑ���� ���α׷����� ���
@Controller
public class Hello {
	int iv =10; //�ν��Ͻ� ����
	static int cv = 20; //static ����
	 
	
	//2. URL�� �޼��� ����
	
	@RequestMapping("/hello") // -> �޼��带 �ܺο��� ȣ�� �����ϰ� �ϰڴٴ� ����. ���������� ������� ȣ�Ⱑ���ϰ� ��.
							  // �ܺο��� ȣ�Ⱑ��������, ���ο����� private��  
	private void main() { // public -> private���� �ٲ㵵 ��Ĺ���� ȣ��/������ ��
		System.out.println("Hello - private");
		
		System.out.println(cv);// ok
		System.out.println(iv);// ok
	}
	
	
//	public void main() { // �ν��Ͻ� �޼��� - iv, cv�� �Ѵ� ��밡��
//		                 // ��Ĺ ���ο��� ��ü������ ���ֱ⶧���� static�� ��� ȣ���� �� )
//		System.out.println("Hello");
//		
//		System.out.println(cv);// ok
//		System.out.println(iv);// ok
//	}

	 
	public static void main2() { // static�޼��� - cv�� ��밡��
								 // static�޼���� �ν��Ͻ� ����� �� �� ����.
		
		System.out.println(cv);// ok
//		System.out.println(iv);// ������
		
		
		
	}
}
