package kr.or.ddit.common.weather.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common/weather/*")
public class WeatherController {
	
	private Logger logger = LoggerFactory.getLogger(WeatherController.class);
	
	@RequestMapping(value = "/weather")
	public String weatherDisplay() {
		return "common/weather/weatherMain";
	}

}
