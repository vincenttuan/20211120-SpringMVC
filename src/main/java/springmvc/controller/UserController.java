package springmvc.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springmvc.entity.User;
import springmvc.service.UserService;

/*
 * API Spec:
 * http://localhost:8080/springmvc/mvc/user/read
 * http://localhost:8080/springmvc/mvc/user/add?name=mary&age=19
 * http://localhost:8080/springmvc/mvc/user/get/mary
 * http://localhost:8080/springmvc/mvc/user/update/mary?age=20
 * http://localhost:8080/springmvc/mvc/user/delete/mary
*/

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(@Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return String.format("Add User Fail: %s", result);
		}
		userService.create(user);
		return userService.read().toString();
	}
	
	@RequestMapping("/read")
	public String read(Model model) {
		List<User> users = userService.read();
		System.out.println("/read -> " + users);
		// 將資料傳給 jsp 去渲染
		model.addAttribute("users", users);
		return "user/user_list";
	}
	
	@RequestMapping("/get/{name}")
	@ResponseBody
	public String get(@PathVariable("name") String name) {
		Optional<User> optUser = userService.getByName(name); 
		return optUser.isPresent()?optUser.get().toString():"Not Found";
	}
	
	@RequestMapping("/update/{name}")
	@ResponseBody
	public String update(@PathVariable("name") String name, @RequestParam("age") Integer newAge) {
		return userService.updateAgeByName(name, newAge) + "";
	}
	
	@RequestMapping("/delete/{name}")
	@ResponseBody
	public String delete(@PathVariable("name") String name) {
		return userService.deleteByName(name) + "";
	}
	
	
	
	 
	
}
