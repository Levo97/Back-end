package com.avinty.hr;


import com.avinty.hr.entity.Department;
import com.avinty.hr.repository.DepartmentRepository;
import com.avinty.hr.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.avinty.hr.entity.Employee;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class HrApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(HrApplication.class, args);

		DepartmentRepository departmentRepository =
				configurableApplicationContext.getBean(DepartmentRepository.class);

		EmployeeRepository employeeRepository =
				configurableApplicationContext.getBean(EmployeeRepository.class);


		Employee employee = Employee.builder()
				.email("teszt@teszt.com")
				.password("123456")
				.full_name("CEO Péter")
				.build();

		employeeRepository.save(employee);


		Department dep = Department.builder()
				.name("Internal IT")
				.created_by(employee)
				.build();

		departmentRepository.save(dep);

		employeeRepository.save(

				Employee.builder()
						.email("teszt2@teszt.com")
						.password("123456")
						.full_name("Teszt Elek")
						.created_by(employee)
						.department(dep)
						.build()
		);

		employeeRepository.save(

				Employee.builder()
						.email("teszt3@teszt.com")
						.password("123456")
						.full_name("Teszt Eltem")
						.created_by(employee)
						.department(dep)
						.build()
		);

		Department dep2 = Department.builder()
				.name("FICO")
				.created_by(employee)
				.build();

		departmentRepository.save(dep2);

		employeeRepository.save(

				Employee.builder()
						.email("teszt4@teszt.com")
						.password("123456")
						.full_name("Teszt Péter")
						.created_by(employee)
						.department(dep2)
						.build()
		);

		employeeRepository.save(

				Employee.builder()
						.email("teszt5@teszt.com")
						.password("123456")
						.full_name("Teszt Ádám")
						.created_by(employee)
						.department(dep2)
						.build()
		);
	}
}
