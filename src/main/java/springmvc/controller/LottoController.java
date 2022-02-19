package springmvc.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import static java.util.function.Function.identity;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.counting;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/lotto")
public class LottoController {
	// 存放 lotto 歷史紀錄
	private List<Set<Integer>> lottos = new ArrayList<>();

	// lotto 主畫面 (Http method = GET)
	// @RequestMapping(value = {"/", "/welcome"}, method = {RequestMethod.GET,
	// RequestMethod.POST})
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String index(Model model) {
		if (lottos.size() > 0) {
			// Lotto 統計資料, 每一個號碼出現的次數
			Map<Integer, Long> stat = null;
			// 將所有號碼匯集成一個 List<Integer> (利用 flatMap 將資料拆散後收集 collect 起來)
			List<Integer> nums = lottos.stream().flatMap(lotto -> lotto.stream()).collect(toList());
			// 將資料透過 groupingby 分組 成為 Map<Integer, Long>
			stat = nums.stream().collect(groupingBy(identity(), counting()));
			// 加上排序
			Map<Integer, Long> statAndSort = new LinkedHashMap<>(); // 放入排序後的結果
			stat.entrySet().stream()
				.sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
				.forEachOrdered(e -> statAndSort.put(e.getKey(), e.getValue()));
			// 將排序後的結果指派給 stat
			stat = statAndSort;
			model.addAttribute("stat", stat);
		}
		// 所有 lotto 號碼資料
		model.addAttribute("lottos", lottos);
		return "lotto/index";
	}

	// 新增/取得最新電腦選號
	@PostMapping("/add")
	public String add(RedirectAttributes attr) {
		// 樂透 539 選號 (1~39 取5個不重複的數字)
		Set<Integer> lotto = getLottoNumIntegers();
		// 將 lotto 資料放入 lottos 集合中
		lottos.add(lotto);
		// 將 lotto 資料傳遞給 /addOk 防止二次 submit
		attr.addFlashAttribute("lotto", lotto); // 資料不會顯示在網址列
		// attr.addAttribute("lotto", lotto); // 資料會顯示在網址列
		return "redirect:addOk";
	}

	@GetMapping(value = { "/addOk", "/updateOk" })
	public String success() {
		return "lotto/success";
	}

	// 換號碼
	@PutMapping("/{index}")
	public String update(@PathVariable("index") int index, RedirectAttributes attr) {
		// 樂透 539 選號 (1~39 取5個不重複的數字)
		Set<Integer> lotto = getLottoNumIntegers();
		// 換號碼
		lottos.set(index, lotto);
		// 直接回到首頁
		return "redirect:./";
		/*
		 * // 將 lotto 資料傳遞給 /updateOk 防止二次 submit attr.addFlashAttribute("lotto",
		 * lotto); //attr.addAttribute("lotto", lotto); return "redirect:../updateOk";
		 */
	}

	// 刪除號碼
	@DeleteMapping("/{index}")
	public String delete(@PathVariable("index") int index) {
		// 移除號碼
		lottos.remove(index);
		// 直接回到首頁
		return "redirect:./";
	}

	private Set<Integer> getLottoNumIntegers() {
		Random r = new Random();
		Set<Integer> lotto = new LinkedHashSet<>();
		while (lotto.size() < 5) {
			lotto.add(r.nextInt(39) + 1);
		}
		return lotto;
	}

}
