package springmvc.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 母路徑 : http://localhost:8080/springmvc/mvc
@Controller
@RequestMapping("/demo")
public class DemoController {
	
	// 子路徑: /demo/hello
	@RequestMapping("/hello")
	public String hello() {
		return "hello"; // 會指向 /WEB-INF/jsp/hello.jsp 頁面
	}
	
	// 子路徑: /demo/helloString
	@RequestMapping("/helloString")
	@ResponseBody
	public String helloString() {
		return "hello"; // 因為有 @ResponseBody 的配置, 所以直接回傳 "hello" 字串
	}
	
	// 帶入 name 與 age 參數
	// 子路徑: /demo/sayhi?name=John&age=18
	@RequestMapping("/sayhi")
	@ResponseBody
	public String sayHi(@RequestParam(value = "name") String name,
						@RequestParam("age") Integer age) {
		return "Hi " + name + ", " + age;
	}
	
	// 帶入 name(必要參數) 與 age(非必要參數) 參數
	// 子路徑: /demo/sayhello?name=John&age=18
	// 子路徑: /demo/sayhello?name=Mary
	// 子路徑: /demo/sayhello  <-- 若有 defaultValue 的配置則該參數可以不用設定
	@RequestMapping("/sayhello")
	@ResponseBody
	public String sayHello(@RequestParam(value = "name", defaultValue = "unknow") String name,
						   @RequestParam(value = "age", defaultValue = "0", required = false) Integer age) {
		return "Hello " + name + ", " + age;
	}
	
	// Lab:
	// 子路徑: /demo/bmi?h=170&w=60
	// 輸出結果: bmi: 20.76
	// 若沒有輸入參數則顯示: bmi: unknow
	@RequestMapping("/bmi")
	@ResponseBody
	public String bmi(@RequestParam(value = "h", defaultValue = "0") Double h,
					  @RequestParam(value = "w", defaultValue = "0") Double w) {
		if(h <=0 || w <= 0) {
			return "bmi: unknow";
		}
		double bmi = w / Math.pow(h/100, 2);
		return String.format("bmi: %.2f", bmi);
	}
	
	// 路徑參數 PathVariable
	// 子路徑: /demo/exam/75 -> 結果: 75 pass
	// 子路徑: /demo/exam/45 -> 結果: 45 fail
	@RequestMapping("/exam/{score}")
	@ResponseBody
	public String exam(@PathVariable("score") Integer score) {
		return String.format("score: %d %s", score, (score>=60)?"Pass":"Fail");
	}
	
	/*
	 * Lab: PathVariable + RequestParam
	 * add 表示加法, sub 表示減法
	 * 路徑：/demo/calc/add?x=30&y=20  -> 結果：50
	 * 路徑：/demo/calc/sub?x=30&y=20  -> 結果：10
	 * 路徑：/demo/calc/sub?y=20       -> 結果：20
	 * 路徑：/demo/calc/sub?x=0&y=20   -> 結果：-20
	 * 路徑：/demo/calc/add            -> 結果：0
	 * 路徑：/demo/calc/abc            -> 結果："None" <- 無此路徑
	 * 提示:可以使用 Optional<Integer> 來取代 Integer
	 * 配置檔要加上 <mvc:annotation-driven /> 才可以使用 Optional<Integer>
	 * */
	@RequestMapping("/calc/{exp}")
	@ResponseBody
	public String calc(@PathVariable("exp") String exp,
					@RequestParam(value = "x", required = false) Optional<Integer> x,
					@RequestParam(value = "y", required = false) Optional<Integer> y) {
		if(x.isPresent() && y.isPresent()) {
			switch (exp) {
				case "add":
					return x.get() + y.get() + "";
					
				case "sub":
					return x.get() - y.get() + "";
							
				default:
					return "None";
			}
		}
		if (!exp.equals("add") || !exp.equals("sub")) return "None";
		if(x.isPresent()) return x.get() + "";
		if(y.isPresent()) return y.get() + "";
		return "0";
	}
	
	
	
	
}
