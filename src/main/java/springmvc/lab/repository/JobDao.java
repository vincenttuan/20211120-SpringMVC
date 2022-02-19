package springmvc.lab.repository;

import java.util.List;

import springmvc.lab.entity.Job;

public interface JobDao {
	// 每頁筆數
	int LIMIT = 5;

	// 取得單筆 job 資料
	public Job get(Integer jid);

	// 新增 job 資料
	public int add(Job job);

	// 修改 job 資料
	public int update(Job job);

	// 查詢所有筆數
	public int getCount();

	// 不分頁全部查詢
	public List<Job> query();

	// 判斷 httpSession 值決定是否要分頁
	public List<Job> query(Object httpSessionValue);

	// 分頁查詢
	public List<Job> queryPage(int offset);

}
