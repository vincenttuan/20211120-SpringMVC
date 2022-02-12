package springmvc.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/lotto")
public class LottoController {
	// 存放 lotto 歷史紀錄
	private List<Set<Integer>> lottos = new ArrayList<>();
	
	// lotto 主畫面 (Http method = GET)
	//@RequestMapping(value = {"/", "/welcome"}, method = {RequestMethod.GET, RequestMethod.POST})
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String index() {
		return "lotto/index";
	}
	
	// 新增/取得最新電腦選號
	@PostMapping("/add")
	public String add(RedirectAttributes attr) {
		// 樂透 539 選號 (1~39 取5個不重複的數字)
		Set<Integer> lotto = getLottoNumIntegers();
		// 將 lotto 資料放入 lottos 集合中
		lottos.add(lotto);
		// 將 lotto 資料傳遞給 addOk.jsp 防止二次 submit
		attr.addAttribute("lotto", lotto);
		attr.addFlashAttribute("lotto", lotto);
		return "redirect:addOk";
	}
	
	@GetMapping("/addOk")
	public String success() {
		return "lotto/success";
	}
	
	private Set<Integer> getLottoNumIntegers() {
		Random r = new Random();
		Set<Integer> lotto = new LinkedHashSet<>();
		while(lotto.size() < 5) {
			lotto.add(r.nextInt(39) + 1);
		}
		return lotto;
	}
	
	
	
}
