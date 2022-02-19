package springmvc.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.entity.Person;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	private List<Person> people = new CopyOnWriteArrayList<>();
	
	// @ModelAttribute Person person 會自動會丟入 person 物件給 view
	// 自動執行 model.addAttribute("person", person);
	@GetMapping("/")
	public String index(@ModelAttribute Person person, Model model) {
		person.setAge(18);
		model.addAttribute("people", people);
		return "person/index";
	}
	/*
	// 手動丟入 person 物件, 效果等同於上方
	@GetMapping("/")
	public String index(Model model) {
		Person person = new Person();
		person.setAge(18);
		model.addAttribute("person", person);
		model.addAttribute("people", people);
		return "person/index";
	}
	*/
	
	// @Valid Person person -> person 物件需經過驗證
	// BindingResult result -> 紀錄上述的驗證結果
	@PostMapping("/")
	public String add(Model model, @Valid Person person, BindingResult result) {
		// 判斷是否有錯誤發生 ?
		if(result.hasErrors()) {
			// 會自動將錯誤訊息丟到指定 view 物件 ("person/index") 中
			model.addAttribute("people", people);
			return "person/index";
		}
		people.add(person);
		return "redirect:./";
	}
	
	
}
