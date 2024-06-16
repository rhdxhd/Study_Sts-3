package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 원격 호출가능한 프로그램으로 등록
@Controller
public class Hello {
	int iv =10; //인스턴스 변수
	static int cv = 20; //static 변수
	 
	
	//2. URL과 메서드 연결
	
	@RequestMapping("/hello") // -> 메서드를 외부에서 호출 가능하게 하겠다는 뜻임. 접근제어자 상관없이 호출가능하게 함.
							  // 외부에서 호출가능하지만, 내부에서는 private임  
	private void main() { // public -> private으로 바꿔도 톰캣에서 호출/실행이 됨
		System.out.println("Hello - private");
		
		System.out.println(cv);// ok
		System.out.println(iv);// ok
	}
	
	
//	public void main() { // 인스턴스 메서드 - iv, cv를 둘다 사용가능
//		                 // 톰캣 내부에서 객체생성을 해주기때문에 static이 없어도 호출이 됨 )
//		System.out.println("Hello");
//		
//		System.out.println(cv);// ok
//		System.out.println(iv);// ok
//	}

	 
	public static void main2() { // static메서드 - cv만 사용가능
								 // static메서드는 인스턴스 멤버를 쓸 수 없음.
		
		System.out.println(cv);// ok
//		System.out.println(iv);// 에러남
		
		
		
	}
}
