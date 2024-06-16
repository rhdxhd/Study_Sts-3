package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main(); // private이라서 외부 호출 불가
		
		// Reflection API를 사용 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능제공
		// java.lang.reflect패키지를 제공
		// Hello클래스의 Class객체(클래스의 정보를 담고 있는 객체)를 얻어온다.
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		// 클래스란 설계도다.
		Hello hello = (Hello)helloClass.newInstance(); //Class객체가 가진 정보로 객체 생성
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); // private인 main()을 호출가능하게 한다.
		
		main.invoke(hello); // =  hello.main()과 똑같음
		//private인 Hello클래스의 main메소드를 원래는 내부에서만 쓸 수있는데,
		//다른클래스에서 Reflection API를 사용해서 호출 함 
	
		//private인데도 호출 가능한 이유,
		//스프링 프레임웍이 자바의 reflection API를 이용해서 객체를 만들기 때문에 가능한 것
		
	}
}
