package springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springmvc.entity.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	private List<Employee> employees = new ArrayList<>();
	@GetMapping("/")
	public String index(Model model, @ModelAttribute Employee employee) {
		/*
		employee.setName("王曉明");
		employee.setAge(18);
		employee.setSalary(88000);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			employee.setBirth(sdf.parse("2010-5-12"));
		} catch (Exception e) {
			
		}
		employee.setEducation("大學");
		employee.setSex("女");
		employee.setInterest(new String[] {"閱讀", "打球"});
		employee.setResume("我愛寫程式...");
		*/
		return "employee/index";
	}
	
	@PostMapping 
	public String add(Employee employee, RedirectAttributes attr) {
		employees.add(employee);
		attr.addFlashAttribute("employee", employee);
		return "redirect:./addOk";
	}
	
	@GetMapping(value = {"/addOk", "/updateOk"})
	public String success() {
		return "employee/success";
	}
	
}
