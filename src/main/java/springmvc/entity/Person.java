package springmvc.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Person {
	@Size(min = 2, max = 50, message = "姓名字數範圍必須介於 2~50 字之間")
	private String name; // 姓名
	
	@NotNull(message = "年齡不可以是空值")
	@Range(min = 0, max = 150, message = "年齡範圍必須介於 0~150 歲之間")
	private Integer age; // 年齡
	
	@NotNull(message = "會員設定不可以是空值")
	private Boolean member; // 是否為會員
	
	@NotNull(message = "生日不可以是空值")
	@Past(message = "生日不可大於今日")
	@JsonFormat(pattern = "yyyy-MM-dd") // 返回日期型態 (傳給 view 表單的資料)
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 接收日期型態 (接收 view 表單的資料)
	private Date birth; // 生日
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getMember() {
		return member;
	}
	public void setMember(Boolean member) {
		this.member = member;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", member=" + member + ", birth=" + birth + "]";
	}
	
	
}
