package sdbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution {

	public static void main(String[] args) {
		System.out.println("Welcome to Student Database Project");
		System.out.println("-------------------------------------");

		//Scanner
		//SMS & SMSImpl-> upcasting
		//while(true) ->infinite loop
		//Menu Driven Program 1:Add Student ......11:exit
		//switch(choice)->case 1: ..........case 11: default
		Scanner scan = new Scanner(System.in);

		//Upcasting to achieve Abstraction
		StudentManagementSystem sms= new StudentManagementSystemImpl();


		//infinite loop 
		while(true) {

			//Menu Driver Program 1: Add Student ...............11.EXIT
			System.out.println("1.Add Student Destails\n2.Display Student\n3.Display All Students");
			System.out.println("4.Remove Student\n5.Remove All Students\n6.Update Student");
			System.out.println("7.Count Students\n8.Sort Students\n9.Get Student With Highest Marks");
			System.out.println("10.Get Student With LowestMarks\n11.EXIT");
			System.out.println("Enter Your Choice :");
			int choice=scan.nextInt();

			switch(choice) {
			case 1:
				sms.addStudent();
				break;

			case 2:
				sms.displayStudent();
				break;

			case 3:
				sms.displayAllStudents();
				break;

			case 4:
				sms.removeStudent();
				break;

			case 5:
				sms.removeAllStudents();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudents();
				break;
			case 8:
				sms.sortStudents();
				break;

			case 9:
				sms.getStudentWithHighestMarks();
				break;

			case 10:
				sms.getStudentWithLowestMarks();
				break;
			case 11:
				System.exit(0);

			default:
				try {
					String message="Invalid Choice, Kindly enter valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}//end of switch

			System.out.println("-----------------------");


		}//end of while loop

	}//end of main()

}//end of class
