package com.amit.memorydb.derby.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amit.memorydb.derby.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
