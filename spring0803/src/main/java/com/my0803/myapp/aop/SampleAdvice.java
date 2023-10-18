package com.my0803.myapp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect //AOP 기능을 가진 모듈이라는 뜻
@Component //빈으로 등록하겠다는 뜻
public class SampleAdvice {
	
	Logger logger = LoggerFactory.getLogger(SampleAdvice.class);
	
	@Before("execution(* com.my0803.myapp.service.BoardService*.*(..))") //지정된곳에 가기 전에 실행하는 기능
	public void startLog() {
		
		
		logger.info("AOP로 로그를 찍어봅니다. 각 메소드를 들어갈 때 메세지가 출력됩니다.");
		System.out.println("이것은 sysout으로 찍어보는 기능입니다.");
	}
}
