package com.utsi.springwebapp.doaImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.utsi.springwebapp.dao.StudentDAO;
import com.utsi.springwebapp.model.Student;

@Service
public class StudentDAOImpl implements StudentDAO{
	
	@Autowired
	@Qualifier("postgresqJDBC2") //change your source in impl for specific database connection
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Student> getAllStudent() {
		String sql = "Select * from stdtable"; // change your query to specific table of specific database
		List<Student> stds = jdbcTemplate.query(sql, new StudentMapper());
		stds.forEach(s->System.out.println(s));
		return stds;
	}
	
	

}
class StudentMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student std = new Student();
		std.setId(rs.getInt("id"));
	     std.setName(rs.getString("name"));
		return std;
	}
	
}
