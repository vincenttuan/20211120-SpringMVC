package springmvc.lab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.lab.entity.Employee;
import springmvc.lab.repository.EmployeeDao;

@Controller
@RequestMapping("/lab/emp")
public class EmpController {
	@Autowired
	private EmployeeDao employeeDao;
	
	@GetMapping("/")
	public String index(@ModelAttribute Employee employee, Model model) {
		model.addAttribute("_method", "POST");
		model.addAttribute("employees", employeeDao.query());
		return "lab/employee";
	}
	
	@PostMapping("/")
	public String add(@Valid Employee employee, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("_method", "POST");
			model.addAttribute("employees", employeeDao.query());
			model.addAttribute("employee", employee);
			return "lab/employee";
		}
		employeeDao.add(employee);
		return "redirect:./";
	}
	
	@GetMapping("/{eid}")
	public String get(@PathVariable("eid") Integer eid, Model model) {
		model.addAttribute("_method", "PUT");
		model.addAttribute("employees", employeeDao.query());
		model.addAttribute("employee", employeeDao.get(eid));
		return "lab/employee";
	}
	
	@PutMapping("/")
	public String update(@Valid Employee employee, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("_method", "PUT");
			model.addAttribute("employees", employeeDao.query());
			model.addAttribute("employee", employee);
			return "lab/employee";
		}
		employeeDao.update(employee);
		return "redirect:./";
	}
	
	@DeleteMapping("/{eid}")
	public String delete(@PathVariable("eid") Integer eid) {
		employeeDao.delete(eid);
		return "redirect:./";
	}
	
}
















