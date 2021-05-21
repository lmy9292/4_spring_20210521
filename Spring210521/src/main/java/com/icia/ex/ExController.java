package com.icia.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.ex.dto.ExDTO;
import com.icia.ex.service.ExService;


@Controller
public class ExController {
	
	@Autowired
	private ExService es;
	
	private ModelAndView mav;

	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}	
		
	@RequestMapping(value = "/insertpage")
	public String insertpage() {
		return "insert";
	}
	
/*	@RequestMapping(value = "/insert")
	public void insert(@RequestParam("co1") String col1,@RequestParam("col2") String col2, 
			@RequestParam("col3") String col3) {
		System.out.println(col1);
		System.out.println(col2);
		System.out.println(col3);
	//회원가입: 아이디,비밀번호,이름, 전화번호,이메일,성별~~
	es.insert1(col1,col2,col3);
	
	//dto를 이용하여 ExService.insert2 메소드로 전달하는 방법
	ExDTO dto = new ExDTO();
	dto.setCol1(col1);
	dto.setCol1(col2);
	dto.setCol1(col3);
	
	es.insert2(dto);
	}*/
	
	//ModelAttribute :dto 필드값을 알아서 담아줌.
	@RequestMapping(value="/insert")
	public void insert(@ModelAttribute ExDTO dto) {
		//dto에 값이 제대로 담겼는지 확인
		System.out.println(dto.toString());
		es.insert2(dto);
	}
	
	@RequestMapping(value="/select")
	public ModelAndView select() {
		mav = es.select();
		return mav;
	}
	
}
