package springmvc.lab.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {
	private Integer eid;
	
	@Size(min = 2, max = 50, message = "{employee.ename.size}")
	private String ename;
	
	@NotNull(message = "{employee.salary.empty}")
	@Range(min = 30000, max = 300000, message = "{employee.salary.range}")
	private Integer salary;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 返回日期時間型態 (傳給 view 表單的資料)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 接收日期時間型態 (接收 view 表單的資料)
	private Date createtime;
	// 加入 jobs : 一個員工可以有多個 Job (一對多)
	private List<Job> jobs;
	
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", createtime=" + createtime
				+ ", jobs=" + jobs + "]";
	}
	
	
	
	
	
}
