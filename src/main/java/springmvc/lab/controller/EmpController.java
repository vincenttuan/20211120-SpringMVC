package springmvc.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.lab.entity.Employee;

@Controller
@RequestMapping("/lab/emp")
public class EmpController {
	
	@GetMapping("/")
	public String index(@ModelAttribute Employee employee, Model model) {
		model.addAttribute("_method", "POST");
		return "lab/employee";
	}
}
