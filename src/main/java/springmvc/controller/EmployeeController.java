package springmvc.controller;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.entity.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute Employee employee) {
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
		return "employee/index";
	}
}
