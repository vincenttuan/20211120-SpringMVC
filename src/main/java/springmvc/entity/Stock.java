package springmvc.entity;

public class Stock {
	private String symbol; // 股票代號: 必須要能有交易的代號
	private Double price; // 買進價格: 必須是昨收的±10%之間
	private Integer amount; // 買進股數: 必須 >= 1000 且是 1000 的倍數
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", price=" + price + ", amount=" + amount + "]";
	}
	
	
}
