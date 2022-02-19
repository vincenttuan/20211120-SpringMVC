package springmvc.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.entity.Stock;
import springmvc.validator.StockValidator;

@Controller
@RequestMapping("/stock")
public class StockController {
	private List<Stock> stocks = new CopyOnWriteArrayList<>();
	
	@Autowired
	private StockValidator stockValidator;
	
	@GetMapping("/")
	public String index(@ModelAttribute Stock stock, Model model) {
		model.addAttribute("stocks", stocks);
		return "stock/index";
	}
	
	@PostMapping("/")
	public String add(@Valid Stock stock, BindingResult result, Model model) {
		// 手動驗證錯誤
		stockValidator.validate(stock, result);
		if(result.hasErrors()) {
			model.addAttribute("stocks", stocks);
			return "stock/index";
		}
		stocks.add(stock);
		return "redirect:./";
	}
	
	
	
}
