package example;

//Program to Auto-Generate Id

public class Employee {
String id;
static int count=101;//Consider a Static counter variable

public Employee() {
this.id="JSP"+count;//initialize the counter variable 
count++; //increment the counter variable

}
	public static void main(String[] args) {
         Employee e1=new Employee();
         Employee e2=new Employee();
         Employee e3=new Employee();
         
         System.out.println(e1.id+" "+e2.id+" "+e3.id);
         
         
	}

}
