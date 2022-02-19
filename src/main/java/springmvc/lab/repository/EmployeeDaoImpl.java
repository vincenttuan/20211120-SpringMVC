package springmvc.lab.repository;

import java.util.List;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import springmvc.lab.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee get(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer eid) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
