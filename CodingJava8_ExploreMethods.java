package com.java8.end;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee {
	int id;

	String name;

	int age;

	String gender;

	String department;

	int yearOfJoining;

	double salary;

	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getDepartment() {
		return department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : "
				+ department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
	}
}

public class CodingJava8_ExploreMethods {
	public static void main(String... args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(10, "Tilak", 31, "Male", "Testing", 1999, 80000.00));
		list.add(new Employee(16, "Seema", 25, "Female", "Support", 2003, 70000.00));
		list.add(new Employee(13, "John", 28, "Male", "Support", 2001, 90000.00));
		list.add(new Employee(11, "Lawrence", 36, "Male", "Testing", 1998, 85000.00));
		list.add(new Employee(18, "Raju", 30, "Male", "Developing", 2000, 93000.00));
		list.add(new Employee(12, "Oviya", 22, "Female", "Developing", 2000, 91000.00));
		list.add(new Employee(19, "Harini", 23, "Female", "Developing", 2023, 90000.00));

		Map<String, Long> departmentCount = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(departmentCount);

		Map<String, Double> averageSal = list.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(averageSal);

		Optional<Employee> high = list.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println(high.get());

		Map<String, Double> departAge = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getAge)));

		System.out.println(departAge);

		Optional<Employee> senior = list.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining))
				.findFirst();

		System.out.println(senior);

		Optional<Employee> junior = list.stream().min(Comparator.comparingInt(Employee::getAge));

		System.out.println(junior);

	}

}
