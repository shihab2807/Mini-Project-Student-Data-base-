package sdbms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.StudentNotFoundException;

public interface StudentManagementSystem {

	void addStudent();
	void displayStudent();
	void displayAllStudents();
	void removeStudent();
	void removeAllStudents();
	void updateStudent();
	void countStudents();
	void sortStudents();
	void getStudentWithHighestMarks();
	void getStudentWithLowestMarks();


}
//All methods inside interface are automatically public and abstract


