package springmvc.lab.repository;

import java.util.List;

import springmvc.lab.entity.Employee;

public interface EmployeeDao {
	// 查詢全部資料-不分頁
	public List<Employee> query();
	
	// 查詢全部資料-透過 httpSessionValue 值決定是否要分頁
	public List<Employee> query(Object httpSessionValue);
	
	// 查詢資料-分頁查詢 (offset 從第幾筆開始查)
	public List<Employee> queryPage(int offset);

	// 取得單筆資料
	public Employee get(Integer eid);
	
	// 新增
	public int add(Employee employee);

	// 修改
	public int update(Employee employee);

	// 刪除
	public int delete(Integer eid);
	
}
