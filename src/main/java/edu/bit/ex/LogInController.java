package edu.bit.ex;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.ex.service.EmpService;
import edu.bit.ex.service.KakakoLoginImpl;
import edu.bit.ex.service.LoginService;
import edu.bit.ex.service.NaverLoginImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LogInController {
	
	@Autowired
	List<LoginService> login;
	
	public LogInController() {
		System.out.println("LogInController()");
	}
	
	@RequestMapping("/login/{num}")
	public String loginNum(@PathVariable("num") int num) {
		System.out.println("loginNum");
		login.get(num).login();
		
		return "login/login";
	}
	
	@RequestMapping("/login")
	public String login() {		
		return "login/login";
	}
	
}
