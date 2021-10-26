package com.amit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.amit.dao.EmployeeDao;
import com.amit.model.Employee;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	
	@Override
	public void insertEmployees(final List<Employee> employees) {
		String sql = "insert into employees (id, first_name, last_name, email_address) " + "values(?, ?, ?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Employee employee = employees.get(i);
				ps.setLong(1, employee.getId());
				ps.setString(2, employee.getFirstName());
				ps.setString(3, employee.getLastName());
				ps.setString(4, employee.getEmailId());
			}
			
			public int getBatchSize() {
				return employees.size();
			}
		});

	}
	
	@Override
	public List<Employee> getAllEmployees(){
		String sql = "SELECT * FROM employees";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Employee> result = new ArrayList<Employee>();
		for(Map<String, Object> row:rows){
			Employee emp = new Employee();
			emp.setId((int)row.get("id"));
            emp.setFirstName((String)row.get("first_name"));
            emp.setLastName((String)row.get("last_name"));
            emp.setEmailId((String)row.get("email_address"));
			result.add(emp);
		}
		
		return result;
	}
}