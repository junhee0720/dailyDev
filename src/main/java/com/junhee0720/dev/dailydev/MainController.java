package com.junhee0720.dev.dailydev;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class MainController {



	@RequestMapping("/")
	public String main(){
		log.info("main /");


		return "main";
	}
}
