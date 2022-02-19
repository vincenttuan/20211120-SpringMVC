package springmvc.lab.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Job {
	private Integer jid;
	
	@Size(min = 2, max = 50, message = "{job.jname.size}")
	private String jname;
	
	@NotNull(message = "{job.eid.empty}")
	private Integer eid;
	
	// 一個 job 可以對應一個員工
	private Employee employee;

	public Integer getJid() {
		return jid;
	}

	public void setJid(Integer jid) {
		this.jid = jid;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Job [jid=" + jid + ", jname=" + jname + ", eid=" + eid + ", employee=" + employee + "]";
	}
	
	
	
}
