package springmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springmvc.entity.Stock;
import yahoofinance.YahooFinance;

@Component
public class StockValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// 判斷 clazz 是否是要驗證的類
		return Stock.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(!(target instanceof Stock)) {
			return;
		}
		Stock stock = (Stock)target;
		// 基礎驗證: 可以使用 ValidationUtils
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "symbol", "stock.symbol.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "stock.price.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "stock.amount.empty");
		
		// 進階驗證
		yahoofinance.Stock yStock = null;
		try {
			yStock = YahooFinance.get(stock.getSymbol());
			// 昨收
			double previousClose = yStock.getQuote().getPreviousClose().doubleValue();
			// 買進價格必須是昨收的±10%之間
			if(stock.getPrice() < previousClose * 0.9 || stock.getPrice() > previousClose * 1.1) {
				// rejectValue 支援 .properties
				errors.rejectValue("price", "stock.price.range");
				errors.reject("price", String.format("(%.1f ~ %.1f)", 
												(previousClose * 0.9), 
												(previousClose * 1.1))
							 );
			}
			// 買進股數必須大於或等於1000
			if(stock.getAmount() < 1000) {
				errors.rejectValue("amount", "stock.amount.notenough");
			}
			// 買進股數必須是1000的倍數(1000股 = 1張)
			if(stock.getAmount() % 1000 != 0) {
				errors.rejectValue("amount", "stock.amount.range");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			if(yStock == null) {
				errors.rejectValue("symbol", "stock.symbol.notfound");
			}
		}
		
	}

}
