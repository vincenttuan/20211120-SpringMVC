package springmvc.entity;

import java.util.Arrays;
import java.util.Date;

public class Employee {
	
	private String name; // 姓名 ->  text 輸入框
	private Integer age; // 年齡 ->  number 輸入框
	private Date birth; // 生日 -> date 輸入框
	private String sex;  // 性別 -> radio 單選核選盒
	private String education; // 學歷 -> select 下拉選單
	private String[] interest; // 興趣 -> checkbox 多選核選盒
	private String resume; // 履歷 -> textarea 大文字欄位
	
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
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String[] getInterest() {
		return interest;
	}
	public void setInterest(String[] interest) {
		this.interest = interest;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", birth=" + birth + ", sex=" + sex + ", education="
				+ education + ", interest=" + Arrays.toString(interest) + ", resume=" + resume + "]";
	}
	
	
	
}
