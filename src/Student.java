//Title     : FT MUR T221 ICT167 C – Assignment 2 (Student class)
//Author    : Tee Yee Kang
//Date      : 30/Jul/2021
//File Name : FTC-34315323-Assignment 02
//Purpose  	: Student class is the base class. This program allowed user to create object
//			  The constructor required 7 different variables to create a student object. User can also create 
//			  student class object without any arguments (default value) by using the constructor with no parameter.
//	     	  There are appropriate getter & setter method for user to retrieve or set student object value.
// 			  Child class can also use the getGrade method to find the grade of student by pasing in the overall mark.

/**
 * @author      TeeYeeKang    yeekang88 @ gmail.com
 * @version     13.0.2          
 */

public class Student {

	//instance variables
	/**
	 * The String title (e.g. Mr, Mrs)
	 */
	private String title;
	/**
	 * The String firstName
	 */
	private String firstName;
	/**
	 * The String lastName
	 */
	private String lastName;
	/**
	 * The long student number
	 */
	private long studentID; 
	/**
	 * The int day of birth
	 */
	private int DOB_day;
	/**
	 * The int month of birth
	 */
	private int DOB_month;
	/**
	 * The int year of birth
	 */
	private int DOB_year;
	
	//default constructor - no parameter
	/**
	 * Default Constructor of Student(base) class                          
	 * <p>
	 * This method is used to represent the default value of String title, String firstName, String lastName, <br>
	 * int studentID, int day of birth, int month of birth, int year of birth
	 * </p>
	 * Precondition - Nil  <br>
	 * Postcondition - A Student object is created with the default value of title, first name, last name <br>
	 * 				   studentID, date of birth(divided in 3 different int component e.g day/month/year).
	 */
	public Student() {
		title = "None";
		firstName = "None";
		lastName = "None";
		studentID = 0; //
		DOB_day = 0;
		DOB_month = 0;
		DOB_year = 0;
	}
	
	//constructor with parameters
	/**
	 * Constructor of Student(base) class                          
	 * <p>
	 * This constructor is used to represent the value of String title, String firstName, String lastName, <br>
	 * int studentID, int day of birth, int month of birth, int year of birth
	 * </p>
	 * Precondition - The value of title, firstName and lastName must be a String type, data type of studentID is long and<br>
	 * 				  date of birth need to be int type(divided into 3 components e.g. day/month/year)<br>
	 * Postcondition - A Student object is created with the value of title, firstName, lastName, studentID,<br>
	 * 				   day of birth, month of birth and year of birth.
	 * @param  InitialTitle Title of the student (e.g. Mr, Mrs, etc)
	 * @param  InitialFirstName First name of the student
	 * @param  InitialLastName Last name of the student
	 * @param  InitialStudentID Student's student number
	 * @param  InitialDOB_day Day of birth of the student
	 * @param  InitialDOB_month Month of birth of the student
	 * @param  InitialDOB_year Year of birth of the student
	 */
	public Student(String InitialTitle, String InitialFirstName, String InitialLastName, 
			long InitialStudentID, int InitialDOB_day, int InitialDOB_month,int InitialDOB_year){
		title = InitialTitle;
		firstName = InitialFirstName;
		lastName = InitialLastName;
		studentID = InitialStudentID;
		DOB_day = InitialDOB_day;
		DOB_month = InitialDOB_month;
		DOB_year = InitialDOB_year;
	}

	//getter and setter methods
	/**
	 * This method is used to get the title of the student (Student object)                        
	 * <p>
	 * Precondition: Title is initialised at the Constructor <br>
	 * Postcondition: The title of the Student object is returned.
	 * </p>   
	 * @return title Return the Student object's title      
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method is used to set the new title of the student (Student object)                        
	 * <p>
	 * Precondition: Take in a new title of Student object with String value<br>
	 * Postcondition: The title of the Student object is set.
	 * </p>   
	 * @param NewTitle Title of Student object      
	 */
	public void setTitle(String NewTitle) {
		title = NewTitle;
	}

	/**
	 * This method is used to get the full name(firstName + lastName) of the student (Student object)                        
	 * <p>
	 * Precondition: Both first name and last name are initialised at the Constructor <br>
	 * Postcondition: The Student object's full name is returned.
	 * </p>   
	 * @return lastName + " " + firstName Return the Student object's full name (firstName + lastName)      
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}

	/**
	 * This method is used to set the student's (Student object) new full name (first name + last name)                        
	 * <p>
	 * Precondition: Take in a both new first name and last name of Student object with String values<br>
	 * Postcondition: The firstName and lastName of the Student object is set.
	 * </p>   
	 * @param NewFirstName First name of Student object
	 * @param NewLastName Last name of Student object     
	 */
	public void setName(String NewFirstName, String NewLastName) {
		firstName = NewFirstName;
		lastName = NewLastName;
	}

	/**
	 * This method is used to get the student number(studentID) of the student (Student object)                        
	 * <p>
	 * Precondition: studentID is initialised at the Constructor <br>
	 * Postcondition: The Student object's studentID is returned.
	 * </p>   
	 * @return studentID Return the Student object's student number (studentID)      
	 */
	public long getStudentID() {
		return studentID;
	}

	/**
	 * This method is used to set the student's (Student object) studentID                
	 * <p>
	 * Precondition: Take in a new studentID of Student object with long value<br>
	 * Postcondition: The studentID of the Student object is set.
	 * </p>   
	 * @param NewStudentID StudentID of Student object     
	 */
	public void setStudentID(long NewStudentID) {
		studentID = NewStudentID;
	}

	//combine day, month, and year together
	/**
	 * This method is used to get the date of birth (day/month/year) of the student (Student object)                        
	 * <p>
	 * Precondition: DOB_day, DOB_month, DOB_year are initialised at the Constructor <br>
	 * Postcondition: The Student object's date of birth including day, month and year are returned.
	 * </p>   
	 * @return DOB_day + "/"+ DOB_month + "/" + DOB_year Return the Student object's date of birth (day/month/year)    
	 */
	public String getDOB() {
		return DOB_day + "/"+ DOB_month + "/" + DOB_year;
	}

	//to set a new DOB, the user have to input day, month, and year
	/**
	 * This method is used to set the student's (Student object) date of birth including day, month and year                
	 * <p>
	 * Precondition: Take in the including day of birth, month of birth and year of birth of Student object with int values<br>
	 * Postcondition: The day of birth, month of birth and year of birth of the Student object is set.
	 * </p>   
	 * @param NewDOB_day Day of birth of Student object 
	 * @param NewDOB_month Month of birth of Student object
	 * @param NewDOB_year Year of birth of Student object    
	 */
	public void setDOB(int NewDOB_day, int NewDOB_month, int NewDOB_year){
		DOB_day = NewDOB_day;
		DOB_month = NewDOB_month;
		DOB_year = NewDOB_year;
	}
	
	//check for same Student object by studentID
	//return true is same, else return false
	//argument required a Student type object
	/**
	 * This method is used to check for same Student object by comparing 2 Student objects' studentID               
	 * <p>
	 * Precondition: Take in a Student object (type Student)<br>
	 * Postcondition: Return true is this studentID is same as the passed in Student object's studentID, else return false.
	 * </p>   
	 * @param std Student type object  
	 * @return this.studentID == std.studentID True is both objects are same  
	 */
	public boolean equals(Student std) {
		return (this.studentID == std.studentID);
	}
	
	//dummy method for calculate overall mark
	/**
	 * This method is just a dummy calculate overall mark method               
	 * <p>
	 * Precondition: Nil<br>
	 * Postcondition: Return a dummy value 0.
	 * </p>   
	 * @return 0 A dummy value
	 */
	public double getOverallScore() {
		return 0;
	}
	
	//find grade based on student's overall score
	//pass in overall score and find grade
	//the if-else statement will find the corresponding grade, then return the grade
	/**
	 * This method is used to find the student's grade by passing in the overall score                
	 * <p>
	 * Precondition: Take in a socre with double type value<br>
	 * Postcondition: Return student's grade based on student's score.
	 * </p>   
	 * @param score Student's overall score    
	 * @return grade Return student's grade
	 */
	public String getGrade(double score) {
		//get overall to find grade
		double overall = score;
		String grade = "null";
		
		//find grade
		if(overall >= 80) {
			grade = "HD";
		}else if(overall >= 70 && overall <80) {
			grade = "D";
		}else if(overall >=60 && overall <70) {
			grade = "C";
		}else if(overall >=50 && overall <60) {
			grade = "P";
		}else {
			grade = "N";
		}
		
		return grade;
	}
	
	//display output method
	//display the details of student including title, full name, date of birth and studentID 
	/**
	 * This method is used to display the details of student including title, full name, date of birth and studentID               
	 * <p>
	 * Precondition: Nil<br>
	 * Postcondition: Display the detials of student object.
	 * </p>       
	 */
	public void writeOutput() {
		System.out.println("Student : " + title + "." + firstName + " " + lastName);
		System.out.println("Student Number : " + studentID);
		System.out.println("Date Of Birth : " + DOB_day + "/"+ DOB_month + "/" + DOB_year);
		System.out.println("-------< Marks >--------");
	}
	
	//display output method in String type
	/**
	 * This method is used to return the details of student including title, full name, date of birth and studentID in String type           
	 * <p>
	 * Precondition: Nil<br>
	 * Postcondition: Return the detials of student object.
	 * </p>       
	 * @return "Student : " + title + "." + lastName + " " + firstName + "\n" 
				+"Student Number : " + studentID + "\n" + "Date Of Birth : " + DOB_day + "/"+ DOB_month + "/" + DOB_year
				+"\n" + "-------< Marks >--------" Return student's details
	 */
	public String writeOutputStr() {
		
		return ("Student : " + title + "." + firstName + " " + lastName + "\n" 
				+"Student Number : " + studentID + "\n" + "Date Of Birth : " + DOB_day + "/"+ DOB_month + "/" + DOB_year
				+"\n" + "-------< Marks >--------");
	}
	
	//New addition
	//dummy method for set mark for all student
	/**
	 * This method is just a dummy set mark method to set mark for all student             
	 * <p>
	 * Precondition: Nil<br>
	 * Postcondition: Return nothing.
	 * </p>   
	 */
	public void setData(String data) {
		//dummy method for override
	}
	
}
