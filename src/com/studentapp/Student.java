package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private String name = null;
	private int age = 0;
	private String studentID = null;
	private List<String> courses = null;
	/**
	 * @param name
	 * @param age
	 * @param studentID
	 */
	public Student(String name, int age, String studentID) {
		super();
		//purpose of this keyword is to differentiate between local variable with instance variable
		if(ValidateAge(age) && validateName(name) && validateStudentID(studentID))
		this.name = name;
		this.age = age;
		this.studentID = studentID;
		courses = new ArrayList<String>();
		
	}
	
	public boolean validateStudentID(String studentID) {
		// TODO Auto-generated method stub
		String strudentRegex = "^S-\\d+$"; 	//S-123
		
		Pattern idPattern = Pattern.compile(strudentRegex);
		Matcher idMatcher = idPattern.matcher(studentID);
		
		if(idMatcher.matches()) {
			return true;
		}else {
			System.err.println("Invalid Student ID!! use the format S-followed by digit!!");
		return false;}
		
	}
//arraylist are non-idempotent which means we can add dup;icate values
	public void enrollCourse(String course) {
		if(ValidateCourseName(course)) {
		if(!(courses.contains(course))) {
			courses.add(course);
			System.out.println("Student is enrolled to "+course+" course successfully!!");
		}
		else {
			System.err.println("Student already added to the "+course+" course.");
		}
		}
	}

	public void printStudentInfo() {
		System.out.println("========== Student Information =========");
		System.out.println("Student Name: "+ name);
		System.out.println("Student Age: "+ age);
		System.out.println("Student ID: "+ studentID);
		System.out.println("Enrolled for course: "+ courses);
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentID=" + studentID + ", courses=" + courses + "]";
	}
	
	// validation methods - for constructor to validate whether the arguments are valid or not--->> Best practice
	public boolean ValidateAge(int age) {
		if(age>=19 && age <= 35) {
			return true;
		}else {
			System.err.println("Student age needs to be between 19 & 35");
			return false;
		}
	}
		
	public boolean validateName(String name) {
		//^ indicates that the string needs to start with an alphabet; \\s indicates white space ; $ indicates the end of string
		String namePattern = "^[a-zA-Z\\s]+$";
		
		Pattern patternName = Pattern.compile(namePattern);
		Matcher nameMatcher = patternName.matcher(name);
		if(nameMatcher.matches()) {
			return true;
		}else {
			System.err.println("Invalid format of name!! enter alphabets only!!");
			return false;
		}
	}
	public boolean ValidateCourseName(String courseName) {
		if(courseName.equalsIgnoreCase("Java") || courseName.equalsIgnoreCase("DSA") || courseName.equalsIgnoreCase("Devops")) 
		{return true;
		}
		else {
			System.err.println("Please select courses from the list[Java/ DSA/ Devops]");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentID() {
		return studentID;
	}

	public List<String> getCourses() {
		return courses;
	}
	
	
}
