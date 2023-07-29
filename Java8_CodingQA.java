package com.java8.end;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Student {
	String name;

	int id;

	String subject;

	int percentage;

	public Student(String name, int id, String subject, int percentage) {
		this.name = name;
		this.id = id;
		this.subject = subject;
		this.percentage = percentage;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public int getPercentage() {
		return percentage;
	}

	@Override
	public String toString() {
		return name + "-" + id + "-" + subject + "-" + percentage;
	}
}

public class Java8_CodingQA {
	public static void main(String... args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("Hari", 100, "CSE", 65));
		list.add(new Student("Winston", 107, "ECE", 53));
		list.add(new Student("John", 102, "CSE", 45));
		list.add(new Student("Smrith", 108, "CSE", 55));
		list.add(new Student("Pushvanth", 103, "ECE", 52));

		// System.out.println(list);
		Map<Boolean, List<Student>> o = list.stream()
				.collect(Collectors.partitioningBy((Student st) -> st.getPercentage() > 60));
		for (Map.Entry<Boolean, List<Student>> e : o.entrySet()) {
			if (e.getKey() == true) {
				System.out.println(e.getKey() + " " + e.getValue());
				break;
			}
		}

		List<Student> top = list.stream().sorted((Student s1, Student s2) -> s2.getPercentage() - s1.getPercentage())
				.limit(3).collect(Collectors.toList());

		System.out.println("Top 3 performer");
		for (Student s : top) {
			System.out.println(s);
		}

		System.out.println("Name and percentage");
		list.stream().forEach((Student s) -> System.out.println(s.getName() + " " + s.getPercentage()));

		List<String> subject = list.stream().map(Student::getSubject).distinct().collect(Collectors.toList());

		System.out.println(subject);

		Set<String> sub = list.stream().map(Student::getSubject).distinct().collect(Collectors.toSet());

		System.out.println(sub);

		IntSummaryStatistics state = list.stream()
				.collect(Collectors.summarizingInt((Student std) -> std.getPercentage()));

		System.out.println("Highest: " + state.getMax());
		System.out.println("Lowest: " + state.getMin());
		System.out.println("Average: " + state.getAverage());

		Long count = list.stream().collect(Collectors.counting());
		System.out.println(count);

		Map<String, List<Student>> studGroupSub = list.stream().collect(Collectors.groupingBy(Student::getSubject));

		System.out.println(studGroupSub);

		Map<String, List<String>> group = list.stream().collect(Collectors.groupingBy((Student s) -> s.getSubject(),
				Collectors.mapping(Student::getName, Collectors.toList())));

		System.out.println(group);

	}

}
