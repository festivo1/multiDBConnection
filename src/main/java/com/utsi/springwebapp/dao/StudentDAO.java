package com.utsi.springwebapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.utsi.springwebapp.model.Student;

@Repository
public interface StudentDAO {

	public List<Student> getAllStudent();
}
