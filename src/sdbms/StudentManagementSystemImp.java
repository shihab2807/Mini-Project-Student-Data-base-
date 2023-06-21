package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.InvalidChoiceException;
import customexception.StudentNotFoundException;



import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;

//2.Implementation Class

class StudentManagementSystemImpl implements StudentManagementSystem{

	Scanner scan =new Scanner(System.in);
	//we are using Collection as our Database ->Map -> LinkedHashMap
	//Key -> Student Id and value ->Student Object

	Map<String,Student> db=new LinkedHashMap<String, Student>();

	@Override
	public void addStudent() {

		//Accepting Age
		System.out.println("Enter Age:");
		int age=scan.nextInt();

		//Accepting Name
		System.out.println("Enter Name:");
		String name=scan.next();

		//Accepting Marks
		System.out.println("Enter Marks:");
		int marks= scan.nextInt();

		//Creating a Student Instance(object)
		Student std=new Student(age, name, marks);

		//Adding Entry inside DB(Map)
		db.put(std.getId(), std);

		System.out.println("Student Record Inserted Successfully");
		System.out.println("Your Student ID is "+std.getId());


	}


	@Override
	public void displayStudent() {
		//Accepting Student id and converting it into upper case
		System.out.println("Enter student ID:");
		String id=scan.next();
		id=id.toUpperCase();

		//checking if the id is present or not
		if(db.containsKey(id)) {
			Student std=db.get(id); //getting values (Student object)
			System.out.println("ID: "+std.getId());
			System.out.println("Age: "+std.getAge());
			System.out.println("Name: "+std.getMarks());
			System.out.println("Marks: "+std.getMarks());

			//System.out.println(std);

		}else {
			try {
				String message="Student with the ID "+id+" is not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}


	}

	@Override
	public void displayAllStudents() {
		//Displaying when the Database is not empty
		if(!db.isEmpty()) {
			System.out.println("Student Details are as follows:");
			System.out.println("---------------------------------");

			//Converting Map into set using KeySet()
			Set<String> keys =db.keySet();//JSP101 JSP102 JSP103....

			//Traversing Key (Student 
			for(String key:keys) {
				System.out.println(db.get(key));
			}
		}
		else {
			try {
				String message="No Student Record found to display";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}



	@Override
	public void removeStudent() {
		System.out.println("Enter Student Id:");
		String id=scan.next().toUpperCase();


		if(db.containsKey(id)) 
		{
			System.out.println("Student Record Found");
			System.out.println(db.get(id));//getting student object
			db.remove(id);
			System.out.println("Student Record Deleted Successfully");
		}else {
			try {
				String message="Student Record with the ID "+id+" is not found";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}

		}

	}


	@Override
	public void removeAllStudents() {
		if(!db.isEmpty()) {
			System.out.println("Number of Student Records: "+db.size());
			db.clear();
			System.out.println("All Student Records are deleted Successfully!");
		}
		else {
			try {
				String message="No Student Record Found to Delete";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}

	}


	@Override
	public void updateStudent() {
		System.out.println("Enter Student Id:");
		String id=scan.next().toUpperCase();


		if(db.containsKey(id)) 
		{
			System.out.println("Student Record Found");
			Student std=db.get(id);//getting student object

			System.out.println("1:Update Age\n2:Update Name");
			System.out.println("3.Update Marks\nEnter choice:");
			int choice = scan.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Enter Age:");
				int age=scan.nextInt();
				std.setAge(age); //std.setAge(scan.nextInt());
				System.out.println("Age Updated Successfully");
				break;
			case 2:
				System.out.println("Enter Name:");
				String name =scan.next();
				std.setName(name); //std.setName(scan.next());
				System.out.println("Name Updated Successfully");
				break;
			case 3:
				System.out.println("Enter Marks:");
				int marks = scan.nextInt();
				std.setMarks(marks);
				System.out.println("Marks Updated Successfully");
				break;

			default:
				try {
					String message="Invalid Choice, Kindly enter valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				String message="Student with the ID "+id+" is not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}


	@Override
	public void countStudents() {
		System.out.println("No of Student records: "+db.size());

	}


	@Override
	public void sortStudents() {
		//Reference of List and object of ArrayList storing Student objects
				List<Student> list = new ArrayList<Student>();

				//Converting Map into Set using keySet()
				Set<String> keys = db.keySet();

				//Traverse Keys
				for(String key : keys) {
					Student std = db.get(key); //getting student objecr
					list.add(std); //adding student object onto list
				}
				System.out.println("1:Sort Student By Id\n2:Sort Student By Age");
				System.out.println("3:Sort Student By Name\n4:Sort Student By Marks");
				System.out.println("Enter Choice:");
				int choice = scan.nextInt();

				switch(choice) {

				case 1:
					Collections.sort(list,new SortStudentById());
					for(Student s : list) {
						System.out.println(s);
					}
					break;

				case 2:
					Collections.sort(list,new SortStudentByAge());
					for(Student s : list) {
						System.out.println(s);
					}
					break;
				case 3:
					Collections.sort(list,new SortStudentByName());
					for(Student s : list) {
						System.out.println(s);
					}
					break;
				case 4:
					Collections.sort(list,new SortStudentByMarks());
					for(Student s : list) {
						System.out.println(s);
					}
					break;

				default:
					try {
						String message="Invalid choice,Kindly enter valid choice";
						throw  new InvalidChoiceException(message);
					}
					catch(Exception e){
						System.out.println(e.getMessage());
					}
				}
	

	}


	@Override
	public void getStudentWithHighestMarks() {
		//Reference of List and object of ArrayList storing Student objects
		List<Student> list = new ArrayList<Student>();

		//Converting Map into Set using keySet()
		Set<String> keys = db.keySet();

		//Traverse Keys
		for(String key : keys) {
			Student std = db.get(key); //getting student object
			list.add(std); //adding student object onto list
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println("Student with Highest Marks:");
		System.out.println(list.get(list.size()-1));


	}


	@Override
	public void getStudentWithLowestMarks() {
		//Reference of List and object of ArrayList storing Student objects
				List<Student> list = new ArrayList<Student>();

				//Converting Map into Set using keySet()
				Set<String> keys = db.keySet();

				//Traverse Keys
				for(String key : keys) {
					Student std = db.get(key); //getting student objecr
					list.add(std); //adding student object onto list
				}
				Collections.sort(list,new SortStudentByMarks());
				System.out.println("Student with Lowest Marks:");
				System.out.println(list.get(0));

			}

	}



