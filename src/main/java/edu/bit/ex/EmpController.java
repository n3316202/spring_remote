package edu.bit.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.ex.service.EmpService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	
		
	@RequestMapping("/emp/list")
	public String list(Model model) {
		System.out.println("list()");
		System.out.println(empService.list());
		model.addAttribute("empList",empService.list());
		
		return "/emp/list";
	}
	
	@RequestMapping("/emp/tables")
	public String tables(Model model) {
		System.out.println("list()");
		System.out.println(empService.list());
		model.addAttribute("empList",empService.list());
		
		return "/emp/tables";
	}
	
}
