package com.sba6.srm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sba6.srm.entity.Employee;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByMgrId(Long mgrId);
}
