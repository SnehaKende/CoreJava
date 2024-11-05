package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main4 {

	private static List<Student> StudentList = new ArrayList<Student>();
	private static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("**********Student MAnagement System**********");
	
		StudentList = new ArrayList<Student>();
		sc = new Scanner(System.in);
		while(true) {
		System.out.println("********** Welcome *********");
		System.out.println("Select an option....");
		System.out.println("1. Register the student");
		System.out.println("2. Find student with student id");
		System.out.println("3. List all student information");
		System.out.println("4. List student information in sorted order");
		System.out.println("5. Exit");
	
		int option = sc.nextInt();
		
		switch(option) {
		case 1: EnrollStudent(sc);
		break;
		case 2 : findStudentByID();
		break;
		case 3 : printAllStudentsData();
		break;
		case 4 : sortByName();
		break;
		case 5: exit();
		break;
		
		default: System.out.println("Invalid option selected!!"
				+ "enter between 1 and 5");
		}}
	}
	private static void exit() {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	private static void printAllStudentsData() {
		// TODO Auto-generated method stub
		if(StudentList.size() > 0) {
		System.out.println("===========Print all student data=========");
		for(Student s : StudentList) {
			s.printStudentInfo();
		}}
		else
		{
			System.err.println("Student list is empty!!");
		}
	}
	private static void EnrollStudent(Scanner sc2) {
		// TODO Auto-generated method stub
		System.out.println("Enter student name : ");
		String stdName = sc2.next();
		
		System.out.println("Enter student age : ");
		int stdAge = sc2.nextInt();
		
		System.out.println("Enter student id : ");
		String stdID = sc2.next();
		
		Student newStudent = new Student(stdName, stdAge, stdID);
		StudentList.add(newStudent);
		System.out.println("Student added to the Student Management System!!");
		while(true) {
		System.out.println("Enter course for student to be enrolled : Type Done to exit");
		String courseName = sc2.next();
		
		if(courseName.equalsIgnoreCase("Done")) {
			break;
		}
		newStudent.enrollCourse(courseName);}
		newStudent.printStudentInfo();
	}
	public static void findStudentByID() {
		Student result = null;
		System.out.println("Enter the student ID to search: ");
		Scanner sc4 = new Scanner(System.in);
		String id = sc4.next();
		try {
			result = StudentList.stream().filter(x -> x.getStudentID().equalsIgnoreCase(id))
		.findFirst()
		.orElseThrow(() -> new RuntimeException("No Data Found!!"));
		}catch(RuntimeException ret) {
			System.err.println("Student ID with "+ id +" not found!!");
		}
		;
		System.out.println("Student with the ID: "+id+"is"+result);
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
}
