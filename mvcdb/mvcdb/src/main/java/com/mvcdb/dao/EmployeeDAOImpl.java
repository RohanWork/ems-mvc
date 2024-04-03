package com.mvcdb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import java.sql.Timestamp;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.mvcdb.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	private static int    idEmp ;
	private static String mailEmp ;
	private static String tokenEmp ;
	
	private final String mainTable  ="employeeM";
	private final String auditTable ="employeeB";
	
	Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		
//	private String generateToken() {
//		return RandomStringUtils.randomAlphanumeric(6);
//	}
	
	
	String sqlInsertMain   = "INSERT INTO "+mainTable+" (name, gender, age, email, address, telephone, department, password, salary, token)"
		    			   + "VALUES (:name, :gender, :age, :email, :address, :telephone, :department, :password, :salary, :token)";

	String sqlInsertAudit  = "INSERT INTO "+auditTable+" (id, name, gender, age, email, address, telephone, department, password, salary, rowInsTms, rowDelTms, status, token)"
		    			   + "VALUES (:id, :name, :gender, :age, :email, :address, :telephone, :department, :password, :salary, :rowInsTms, :rowDelTms, :status, :token)";

	String sqlUpdateMain   = "UPDATE "+mainTable+" SET name=:name, gender=:gender, age=:age, email=:email, address=:address, telephone=:telephone, department=:department, password=:password, salary=:salary WHERE id=:idEmp";

	String sqlUpdateAuditP = "UPDATE "+auditTable+" set rowDelTms=:rowDelTms, status=:status where token=:tokenEmp and status='created'";
	
	String sqlUpdateAudit  = "UPDATE "+auditTable+" set rowDelTms=:rowDelTms, status=:status where email=:email and status='created'";
	
	String sqlDeleteMain   = "DELETE FROM "+mainTable+" WHERE id=:id";
	
	String sqlEmployeeByIdMain  = "SELECT * FROM "+mainTable+" WHERE id=:id";
	
	String sqlEmployeeByTkMain  = "SELECT * FROM "+mainTable+" WHERE token=:token";
	
	String sqlEmployeeByIdAudit = "SELECT * FROM "+auditTable+" WHERE status=:status and token=:token";
	
	String sqlAuditList = "SELECT * FROM "+auditTable;
	
	
//	Map<String, Object> parameterValues = source.getValues();
//	for (Map.Entry<String, Object> entry : parameterValues.entrySet()) {
//	    String paramName = entry.getKey();
//	    Object paramValue = entry.getValue();
//	    System.out.println(paramName + ": " + paramValue);
//	}System.out.println("\n");
	
	
	public void saveOrUpdate(Employee employee) {
		MapSqlParameterSource source = getParam(employee);
		Map<String,Object> map = source.getValues();
		for(Map.Entry<String, Object> test : map.entrySet()) {
			System.out.println(test.getKey());
			System.out.println(test.getValue());
			System.out.println("\n");
		}
		
		if (idEmp > 0) {
			source.addValue("idEmp", idEmp);
			int res = jdbcTemplate.update(sqlUpdateMain, source);
			if(res>0) {
				source.addValue("rowDelTms", currentTimestamp);
				source.addValue("status", "updated");
				source.addValue("id", idEmp);
				jdbcTemplate.update(sqlUpdateAuditP, source);
			}
			if(res>0) {
				source.addValue("id", idEmp);
				source.addValue("token", tokenEmp);
				source.addValue("rowInsTms", currentTimestamp);
				source.addValue("rowDelTms", null);
				source.addValue("status", "created");
				jdbcTemplate.update(sqlInsertAudit, source);
			}
		} else {	
			String generatedToken = employee.getToken();
			source.addValue("token", generatedToken);			
			int status = jdbcTemplate.update(sqlInsertMain, source);
			
			Employee mainRecord = getFormMainId(generatedToken);
			if (status>0) {
				source.addValue("id", mainRecord.getId());
				source.addValue("rowInsTms", currentTimestamp);
				source.addValue("rowDelTms", null);
				source.addValue("status", "created");
				jdbcTemplate.update(sqlInsertAudit, source);	
			}
		}
		
//		Map<String, Object> parameterValues = source.getValues();
//		for (Map.Entry<String, Object> entry : parameterValues.entrySet()) {
//		    String paramName = entry.getKey();
//		    Object paramValue = entry.getValue();
//		    System.out.println(paramName + ": " + paramValue);
//		}System.out.println("\n");
		
	}

	public void delete(int employeeId) {
		Employee empMain  = getFormMain(employeeId);		
		Employee empAudit = getFormAudit(empMain.getToken(), "created");
		
		MapSqlParameterSource source = getParam(empMain);
		
		if (empAudit==null) {
			source.addValue("rowInsTms", currentTimestamp);
			source.addValue("rowDelTms", null);
			source.addValue("status", "created");
			jdbcTemplate.update(sqlInsertAudit, source);
		}
		
		int res = jdbcTemplate.update(sqlDeleteMain, source);
		if (res>0) {
			source.addValue("rowDelTms", currentTimestamp); 
			source.addValue("status", "deleted");
			jdbcTemplate.update(sqlUpdateAudit, source);
		}
	}

	public List<Employee> list() {
		String sql = "SELECT * FROM employeeM";
		List<Employee> listEmployee = jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>() {
			
			List<Employee> res = new ArrayList<Employee>();

			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()){
						Employee employee = new Employee();
						employee.setId(rs.getInt("id"));
						employee.setName(rs.getString("name"));
						employee.setGender(rs.getString("gender"));
						employee.setAge(rs.getInt("age"));
						employee.setEmail(rs.getString("email"));
						employee.setAddress(rs.getString("address"));
						employee.setTelephone(rs.getString("telephone"));
						employee.setDepartment(rs.getString("department"));
						employee.setPassword(rs.getString("password"));
						employee.setSalary(rs.getDouble("salary"));
						employee.setToken(rs.getString("token"));
						res.add(employee);
					
				}
				return res;
			}
		});
		
//		List<Employee> listEmployee = jdbcTemplate.query(sql, new RowMapper<Employee>() {
//
//			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Employee employee = new Employee();
//	
//				employee.setId(rs.getInt("id"));
//				employee.setName(rs.getString("name"));
//				employee.setGender(rs.getString("gender"));
//				employee.setAge(rs.getInt("age"));
//				employee.setEmail(rs.getString("email"));
//				employee.setAddress(rs.getString("address"));
//				employee.setTelephone(rs.getString("telephone"));
//				employee.setDepartment(rs.getString("department"));
//				employee.setPassword(rs.getString("password"));
//				employee.setSalary(rs.getDouble("salary"));
//				return employee;
//			}
//			
//		});
		
		return listEmployee;
	}

	public Employee getFormMain(int employeeId) {
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("id", employeeId);
		idEmp = employeeId;
		return jdbcTemplate.query(sqlEmployeeByIdMain, source, new ResultSetExtractor<Employee>() {

			public Employee extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Employee employee = new Employee();
					employee.setId(rs.getInt("id"));
					employee.setName(rs.getString("name"));
					employee.setGender(rs.getString("gender"));
					employee.setAge(rs.getInt("age"));
					employee.setEmail(rs.getString("email"));
					employee.setAddress(rs.getString("address"));
					employee.setTelephone(rs.getString("telephone"));
					employee.setDepartment(rs.getString("department"));
					employee.setPassword(rs.getString("password"));
					employee.setSalary(rs.getDouble("salary"));
					employee.setToken(rs.getString("token"));
					mailEmp  = employee.getEmail();
					tokenEmp = employee.getToken();
					return employee;
				}
				
				return null;
			}
			
		});
	}
	
	public Employee getFormMainId(String token) {
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("token", token);
		return jdbcTemplate.query(sqlEmployeeByTkMain, source, new ResultSetExtractor<Employee>() {

			public Employee extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Employee employee = new Employee();
					employee.setId(rs.getInt("id"));
					employee.setToken(rs.getString("token"));
					return employee;
				}
				
				return null;
			}
			
		});
	}
	
	public Employee getFormAudit(String token, String status) {
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("token", token);
		source.addValue("status", status);
		return jdbcTemplate.query(sqlEmployeeByIdAudit, source, new ResultSetExtractor<Employee>() {

			public Employee extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Employee employee = new Employee();
					employee.setId(rs.getInt("id"));
					employee.setName(rs.getString("name"));
					employee.setGender(rs.getString("gender"));
					employee.setAge(rs.getInt("age"));
					employee.setEmail(rs.getString("email"));
					employee.setAddress(rs.getString("address"));
					employee.setTelephone(rs.getString("telephone"));
					employee.setDepartment(rs.getString("department"));
					employee.setPassword(rs.getString("password"));
					employee.setSalary(rs.getDouble("salary"));
					employee.setRowInsTime(rs.getTimestamp("rowInsTms"));
					employee.setRowDelTime(rs.getTimestamp("rowDelTms"));
					employee.setStatus(rs.getString("status"));
					employee.setToken(rs.getString("token"));

					return employee;
				}
				
				return null;
			}
			
		});
	}
	
	public MapSqlParameterSource getParam(Employee employee) {
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("name", employee.getName());
		source.addValue("gender", employee.getGender());
		source.addValue("age", employee.getAge());
		source.addValue("email", employee.getEmail());
		source.addValue("address", employee.getAddress());
		source.addValue("telephone", employee.getTelephone());
		source.addValue("department", employee.getDepartment());
		source.addValue("password", employee.getPassword());
		source.addValue("salary", employee.getSalary());
		source.addValue("id", employee.getId());
		source.addValue("token", employee.getToken());
		source.addValue("idEmp", idEmp);
		source.addValue("mailEmp", mailEmp);
		source.addValue("tokenEmp", tokenEmp);
		return source;
		
	}

	@Override
	public String generateTokenTest() {
		return RandomStringUtils.randomAlphanumeric(6);
	}

	@Override
	public List<Employee> getAuditList() {
		List<Employee> auditEmployee = jdbcTemplate.query(sqlAuditList, new ResultSetExtractor<List<Employee>>() {
			List<Employee> auditData = new ArrayList<>();
			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Employee employee = new Employee();
					employee.setId(rs.getInt("id"));
					employee.setName(rs.getString("name"));
					employee.setAge(rs.getInt("age"));
					employee.setGender(rs.getString("gender"));
					employee.setEmail(rs.getString("email"));
					employee.setAddress(rs.getString("address"));
					employee.setTelephone(rs.getString("telephone"));
					employee.setDepartment(rs.getString("department"));
					employee.setPassword(rs.getString("password"));
					employee.setSalary(rs.getDouble("salary"));
					employee.setRowInsTime(rs.getTimestamp("rowInsTms"));
					employee.setRowDelTime(rs.getTimestamp("rowDelTms"));
					employee.setStatus(rs.getString("status"));
					employee.setToken(rs.getString("token"));
					auditData.add(employee);
				}
				return auditData;
			}
		});
		
		return auditEmployee;
	}
	
//	@Override
//	public List<Employee> getAuditList() {
//		List<Employee> listEmployee = jdbcTemplate.query(sqlAuditList, new ResultSetExtractor<List<Employee>>() {
//			
//			List<Employee> res = new ArrayList<Employee>();
//
//			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
//				while (rs.next()){
//						Employee employee = new Employee();
//						employee.setId(rs.getInt("id"));
//						employee.setName(rs.getString("name"));
//						employee.setGender(rs.getString("gender"));
//						employee.setAge(rs.getInt("age"));
//						employee.setEmail(rs.getString("email"));
//						employee.setAddress(rs.getString("address"));
//						employee.setTelephone(rs.getString("telephone"));
//						employee.setDepartment(rs.getString("department"));
////						employee.setPassword(rs.getString("password"));
//						employee.setSalary(rs.getDouble("salary"));
//						employee.setRowInsTime(rs.getTimestamp("rowInsTms"));
//						employee.setRowDelTime(rs.getTimestamp("rowInsTms"));
//						employee.setStatus(rs.getString("status"));
//						employee.setToken(rs.getString("token"));
//						res.add(employee);
//					
//				}
//				return res;
//			}
//		});
//		return listEmployee;
//	}

}



