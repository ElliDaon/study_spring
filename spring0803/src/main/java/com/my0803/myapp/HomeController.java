package com.my0803.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//컨트롤러 용도의 bean으로 등록한다는 뜻
@Controller
public class HomeController {
	
	//@Resource(name="db") //객체참조변수 이름으로 찾는다
	//@Inject 
	@Autowired //메모리공간안에 같은 타입객체를 찾는다
	DriverManagerDataSource dmds; //멤버변수에 주입을 시킨다.(Dependency Inject - DI)

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/introduction.do", method = RequestMethod.GET)
	public String introduction() {
		
		System.out.println("dmds 주소값이 있나요?" + dmds);
		return "introduction";
	}
	
}
