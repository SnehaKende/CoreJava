package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	private static List<Student> StudentList = new ArrayList<Student>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("**********Student MAnagement System**********");
		System.out.println("********** Welcome *********");

		//Reference variable, it stores the unique id of the object called hashcode
		Student S1;
		S1 = new Student("Sneha", 22, "S-123");
		System.out.println(S1);
		S1.enrollCourse("Java");
		S1.enrollCourse("DSA");
		S1.enrollCourse("C#");
	
		
		// sysout only S1 will print the instance variables as per the overridden ToString method, 
		//if the ToString method is not defined, 
		//it will simply display the hashcode
		
		Student s2 = new Student("Uday", 24, "S-134");
		s2.enrollCourse("Java");
	
		
		Student s3 = new Student("Ritu", 27, "S-138");
		s3.enrollCourse("Devops");
		
		Student s4 = new Student("Ajinkya", 26, "S-140");
		s4.enrollCourse("Java");
		//Add Student objects
		StudentList.add(S1);
		StudentList.add(s2);
		StudentList.add(s3);
		StudentList.add(s4);
		
		Student resultSearch = findStudentByID("S-1");
		System.out.println(resultSearch);
		
		sortByName();
		
	}
private static void sortByName() {
		// TODO Auto-generated method stub
		Comparator<Student> StudentComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
				
				
				/*
												 * new Comparator<Student>() {
												 * 
												 * @Override public int compare(Student o1, Student o2) { // TODO
												 * Auto-generated method stub return
												 * o1.getName().compareTo(o2.getName()); } };
												 */
		Collections.sort(StudentList, StudentComparator);
		System.out.println(StudentList);
	}
public static Student findStudentByID(String StudentId) {
	Student result = null;
	try {
	result = StudentList.stream().filter(x -> x.getStudentID().equalsIgnoreCase(StudentId))
	.findFirst()
	.orElseThrow(() -> new RuntimeException("No Data Found!!"));
	}catch(RuntimeException ret) {
		System.err.println("Student ID with "+ StudentId +" not found!!");
	}
	;
	return result;
}

}
