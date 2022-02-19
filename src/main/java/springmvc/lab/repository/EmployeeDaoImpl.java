package springmvc.lab.repository;

import java.util.List;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonFormat;

import springmvc.lab.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	private static final int LIMIT = 5;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Employee> query() {
		String sql = "select e.eid, e.ename, e.salary, e.createtime, "
				+ "	j.jid as job_jid, j.jname as job_jname, j.eid as job_eid "
				+ " from employee e left join job j "
				+ " on e.eid = j.eid";
		
		ResultSetExtractor<List<Employee>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
				.addKeys("eid")
				.newResultSetExtractor(Employee.class);
		
		List<Employee> employees = jdbcTemplate.query(sql, resultSetExtractor);
		return employees;
	}

	@Override
	public List<Employee> query(Object httpSessionValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> queryPage(int offset) {
		String sql = "select e.eid, e.ename, e.salary, e.createtime, "
				+ "	j.jid as job_jid, j.jname as job_jname, j.eid as job_eid "
				+ " from employee e left join job j "
				+ " on e.eid = j.eid "
				+ " order by e.eid ";
		
		// 分頁查詢
		if(offset >= 0) {
			sql += String.format(" limit %d offset %d ", LIMIT, offset);
		}
		
		ResultSetExtractor<List<Employee>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
				.addKeys("eid")
				.newResultSetExtractor(Employee.class);
		
		List<Employee> employees = jdbcTemplate.query(sql, resultSetExtractor);
		return employees;
	}

	@Override
	public Employee get(Integer eid) {
		String sql = "select eid, ename, salary, createtime from employee where eid=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {eid}, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public int add(Employee employee) {
		String sql = "Insert into employee(ename, salary) values(?, ?)";
		return jdbcTemplate.update(sql, employee.getEname(), employee.getSalary());
	}

	@Override
	public int update(Employee employee) {
		String sql = "update employee set ename=?, salary=? where eid=?";
		return jdbcTemplate.update(sql, employee.getEname(), employee.getSalary(), employee.getEid());
	}

	@Override
	public int delete(Integer eid) {
		String sql = "delete from employee where eid=?";
		return jdbcTemplate.update(sql, eid);
	}
	
}
