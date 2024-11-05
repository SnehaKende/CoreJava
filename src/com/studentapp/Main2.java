package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	private static List<Student> StudentList = new ArrayList<Student>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("**********Student MAnagement System**********");
		System.out.println("********** Welcome *********");

		StudentList = new ArrayList<Student>();
	// read input from the terminal
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student name:");
		String name = sc.next();// if you want to read the input in string format you will use next method
		System.out.println("You have entered the name "+name);
		
		//to read the integer from the terminal you will use readInt
		System.out.println("Enter student name:");
		int age = sc.nextInt();
		System.out.println("You have entered the age "+age);
	}

}
