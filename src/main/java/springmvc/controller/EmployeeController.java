package springmvc.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		model.addAttribute("employees", employees);
		return "employee/index";
	}
	
	@PostMapping(value = "/") 
	public String add(Employee employee, RedirectAttributes attr) {
		employees.add(employee);
		attr.addFlashAttribute("employee", employee);
		return "redirect:./addOk";
	}
	
	@GetMapping(value = {"/addOk", "/updateOk"})
	public String success() {
		return "employee/success";
	}
	
	@GetMapping(value = "/{index}") 
	public String get(@PathVariable("index") int index, Model model) {
		Employee employee = employees.get(index);
		model.addAttribute("employee", employee);
		model.addAttribute("index", index); // 要多加入 index, 給修改頁面用
		return "employee/update";
	}
	
	@PutMapping(value = "/{index}") 
	public String update(@PathVariable("index") int index, Employee employee, RedirectAttributes attr) {
		employees.set(index, employee);
		attr.addFlashAttribute("employee", employee);
		return "redirect:./updateOk";
	}
	
	@DeleteMapping(value = "/{index}") 
	public String delete(@PathVariable("index") int index) {
		employees.remove(index);
		return "redirect:./";
	}
	
	
	
}
