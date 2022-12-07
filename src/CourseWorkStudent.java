//Title     : FT MUR T221 ICT167 C – Assignment 2 (Student class)
//Author    : Tee Yee Kang
//Date      : 30/Jul/2021
//File Name : FTC-34315323-Assignment 02
//Purpose  	: There are two different type of student which is CourseWorkStudent and ResearchStudent.
//			  CourseWorkStudent class is the child class of Student class. Therefore, it required variables in base class
//            and its own variables to create object. User can also create student class object without
//			  any arguments (default value) by using the constructor with no parameter. 
//			  There are appropriate getter & setter method for user to retrieve or set student object value.
//     	      It can also use the methods in the base class.

/**
 * @author      TeeYeeKang    yeekang88 @ gmail.com
 * @version     13.0.2          
 */

public class CourseWorkStudent extends Student{

	//instance variables
	/**
	 * The double assignment1 marks
	 */
	private double assignment1;
	/**
	 * The double assignment2 marks
	 */
	private double assignment2;
	/**
	 * The double practical work marks
	 */
	private double practicalWork;
	/**
	 * The double final exam marks
	 */
	private double finalExam;
	/**
	 * The double overall marks
	 */
	private double overall;
	/**
	 * The String student's grade
	 */
	private String grade;
	
	//default constructor
	//super key word will inherit the default construtor in base class
	/**
	 * Default Constructor of CourseWorkStudent(child) class                          
	 * <p>
	 * This method is used to represent the default value of double assignment1, assignment2, practicalWork, finalExam<br>
	 * overall and String grade
	 * </p>
	 * Precondition - Nil  <br>
	 * Postcondition - A CourseWorkStudent object is created with all the default value including the value of base class<br>
	 * 				   and its own variables.
	 */
	public CourseWorkStudent() {
		super(); //call default constructor of super class Student
		assignment1 = 0;
		assignment2 = 0;
		practicalWork = 0;
		finalExam = 0;
		overall = 0;
		grade = "No grade";	
	}
	
	//constructor overload - different arguments
	//takes in the variables of Student class only
	/**
	 * Overloading Constructor of CourseWorkStudent(child) class                          
	 * <p>
	 * This method is used to create CourseWorkStudent object without all the marks<br>
	 * </p>
	 * Precondition - Takes in Student object's variables. The value of title, firstName and lastName must be a String type,<br>
	 *  			  data type of studentID is long.<br>
	 * 				  date of birth need to be int type(divided into 3 components e.g. day/month/year)<br>
	 * Postcondition - A CourseWorkStudent object is created with Student class variables only.
	 * @param  InitialTitle Title of the student (e.g. Mr, Mrs, etc)
	 * @param  InitialFirstName First name of the student
	 * @param  InitialLastName Last name of the student
	 * @param  InitialStudentID Student's student number
	 * @param  InitialDOB_day Day of birth of the student
	 * @param  InitialDOB_month Month of birth of the student
	 * @param  InitialDOB_year Year of birth of the student
	 */
	public CourseWorkStudent(String InitialTitle, String InitialFirstName, String InitialLastName, 
			long InitialStudentID, int InitialDOB_day, int InitialDOB_month,int InitialDOB_year) {
		super(InitialTitle,InitialFirstName, InitialLastName,InitialStudentID,InitialDOB_day,InitialDOB_month,InitialDOB_year);	
	}
	
	//constructor overload - different arguments
	//takes in the value of ResearchStudent class only
	/**
	 * Overloading Constructor of CourseWorkStudent(child) class                          
	 * <p>
	 * This method is used to create CourseWorkStudent object with marks only and without the variables of Student class<br>
	 * </p>
	 * Precondition - Takes in only double type of assignment1 marks, assignment2 mark, practical work mark and final exam marks.<br>
	 * Postcondition - A CourseWorkStudent object is created with all the marks only.
	 * @param  InitialAssignment1 Assignment 1 marks
	 * @param  InitialAssignment2 Assignment 2 marks
	 * @param  InitialPracticalWork Practical work marks
	 * @param  InitialFinalExam Final exam mark
	 */
	public CourseWorkStudent(double InitialAssignment1, double InitialAssignment2, double InitialPracticalWork,double InitialFinalExam) {
		super(); //call default constructor of super class Student
		assignment1 = InitialAssignment1;
		assignment2 = InitialAssignment2;
		practicalWork = InitialPracticalWork;
		finalExam = InitialFinalExam;
	}
	
	
	//constructor with parameters
	//super key word will inherit the construtor with parameters in base class
	/**
	 * Constructor of CourseWorkStudent(child) class                          
	 * <p>
	 * This constructor is used to represent the value of String title, String firstName, String lastName, <br>
	 * int studentID, int day of birth, int month of birth, int year of birth, double InitialAssignment1 marks,
	 * double InitialAssignment2 marks, double InitialPracticalWork mark and double InitialFinalExam mark. 
	 * Overall marks and grade not included because it has to be calculated.
	 * </p>
	 * Precondition - The value of title, firstName and lastName must be a String type, data type of studentID is long,<br>
	 * 				  date of birth need to be int type(divided into 3 components e.g. day/month/year)<br>
	 * 				  and double type of assignment1 marks, assignment2 mark, practical work mark and final exam marks<br>
	 * Postcondition - A CourseWorkStudent object is created with the value of title, firstName, lastName, studentID,<br>
	 * 				   day of birth, month of birth, year of birth, assignment1, assignment2, practicalWork and finalExam.
	 * @param  InitialTitle Title of the student (e.g. Mr, Mrs, etc)
	 * @param  InitialFirstName First name of the student
	 * @param  InitialLastName Last name of the student
	 * @param  InitialStudentID Student's student number
	 * @param  InitialDOB_day Day of birth of the student
	 * @param  InitialDOB_month Month of birth of the student
	 * @param  InitialDOB_year Year of birth of the student
	 * @param  InitialAssignment1 Assignment 1 marks
	 * @param  InitialAssignment2 Assignment 2 marks
	 * @param  InitialPracticalWork Practical work marks
	 * @param  InitialFinalExam Final exam mark
	 */
	public CourseWorkStudent(String InitialTitle, String InitialFirstName, String InitialLastName, 
			long InitialStudentID, int InitialDOB_day, int InitialDOB_month,int InitialDOB_year,
			double InitialAssignment1, double InitialAssignment2, double InitialPracticalWork,double InitialFinalExam){ 
		
		//call default constructor of super class Student and pass in the arguments
		super(InitialTitle,InitialFirstName,InitialLastName,InitialStudentID,InitialDOB_day,InitialDOB_month,InitialDOB_year);
		assignment1 = InitialAssignment1;
		assignment2 = InitialAssignment2;
		practicalWork = InitialPracticalWork;
		finalExam = InitialFinalExam;
	}

	//getter and setter methods
	/**
	 * This method is used to get the assignment 1 marks of coursework student(CourseWorkStudent object)                        
	 * <p>
	 * Precondition: assignment1 is initialised at the Constructor <br>
	 * Postcondition: The assignment 1 mark of the CourseWorkStudent object is returned.
	 * </p>   
	 * @return assignment1 Return the CourseWorkStudent object's assignmetn 1 mark    
	 */
	public double getAssigment1() {
		return assignment1;
	}

	/**
	 * This method is used to set the new assignment 1 mark of coursework student(CourseWorkStudent object)                       
	 * <p>
	 * Precondition: Take in a new assignment 1 mark of double value<br>
	 * Postcondition: The assignment 1 mark of the CourseWorkStudent object is set.
	 * </p>   
	 * @param NewAssignment1 Assignment 1 mark of CourseWorkStudent object      
	 */
	public void setAssignment1(double NewAssignment1) {
		assignment1 = NewAssignment1;
	}

	/**
	 * This method is used to get the assignment 2 marks of coursework student(CourseWorkStudent object)                        
	 * <p>
	 * Precondition: assignment2 is initialised at the Constructor <br>
	 * Postcondition: The assignment 2 mark of the CourseWorkStudent object is returned.
	 * </p>   
	 * @return assignment2 Return the CourseWorkStudent object's assignment 2 mark    
	 */
	public double getAssignment2() {
		return assignment2;
	}

	/**
	 * This method is used to set the new assignment 2 mark of coursework student(CourseWorkStudent object)                       
	 * <p>
	 * Precondition: Take in a new assignment 2 mark of double value<br>
	 * Postcondition: The assignment 1 mark of the CourseWorkStudent object is set.
	 * </p>   
	 * @param NewAssignment2 Assignment 2 mark of CourseWorkStudent object      
	 */
	public void setAssignment2(double NewAssignment2) {
		assignment2 = NewAssignment2;
	}

	/**
	 * This method is used to get the practical work marks of coursework student(CourseWorkStudent object)                        
	 * <p>
	 * Precondition: practicalWork is initialised at the Constructor <br>
	 * Postcondition: The practical work mark of the CourseWorkStudent object is returned.
	 * </p>   
	 * @return practicalWork Return the CourseWorkStudent object's practical work mark    
	 */
	public double getPracticalWork() {
		return practicalWork;
	}

	/**
	 * This method is used to set the new practical work mark of coursework student(CourseWorkStudent object)                       
	 * <p>
	 * Precondition: Take in a new practical work mark of double value<br>
	 * Postcondition: The practical work mark of the CourseWorkStudent object is set.
	 * </p>   
	 * @param NewPracticalWork Practical work mark of CourseWorkStudent object      
	 */
	public void setPracticalWork(double NewPracticalWork) {
		practicalWork = NewPracticalWork;
	}

	/**
	 * This method is used to get the final exam marks of coursework student(CourseWorkStudent object)                        
	 * <p>
	 * Precondition: finalExam is initialised at the Constructor <br>
	 * Postcondition: The final exam mark of the CourseWorkStudent object is returned.
	 * </p>   
	 * @return finalExam Return the CourseWorkStudent object's final exam mark    
	 */
	public double getFinalExam() {
		return finalExam;
	}

	/**
	 * This method is used to set the new final exam mark of coursework student(CourseWorkStudent object)                       
	 * <p>
	 * Precondition: Take in a new final exam mark of double value<br>
	 * Postcondition: The final exam mark of the CourseWorkStudent object is set.
	 * </p>   
	 * @param NewFinalExam Final exam mark of CourseWorkStudent object      
	 */
	public void setFinalExam(double NewFinalExam) {
		finalExam = NewFinalExam;
	}

	//calculate the overall score of research student
	//return sum of assignment1Score, assignment2Score, practicalWorkScore and finalExamScore
	//assignment 1 and 2 worth 25%, finalExam worth 30% and practicalWork no required further calculation
	/**
	 * This method is used to calculate the overall mark of coursework student(CourseWorkStudent object)                          
	 * <p>
	 * Precondition: Nil<br>
	 * Postcondition: Return the overall mark of student after the calcualtion is completed.
	 * </p>   
	 * @return overall Return the overall mark of coursework student(CourseWorkStudent object)      
	 */
	public double getOverallScore() {
		
		//calculate each mark
		double assignment1Score= this.assignment1 * 25 / 100;
		double assignment2Score= this.assignment2 * 25 / 100;
		double practicalWorkScore = this.practicalWork;  //marked out of a maximum of 20 marks, no further calculation
		double finalExamScore = this.finalExam * 30 / 100 ;
		
		//calculate overall score
		overall = assignment1Score + assignment2Score + practicalWorkScore + finalExamScore;
		return overall;
	}
	
	//display output method
	//display the details of coursework student including base class varaibles value and itw own marks and grade
	//super key word inherit the writeOutput method in base class
	/**
	 * This method is used to display the details of coursework student including base class variables
	 * (title, full name, date of birth and studentID), its own variables assignment1, assignment2,
	 * practicalWork, finalExam and call getOverallScore and getGrade method to get the overall mark and grade respectively
	 * <p>
	 * Precondition: Nil<br>
	 * Postcondition: Display the detials of CourseWorkStudent object including base class variables.
	 * </p>       
	 */
	public void writeOutput() {
		super.writeOutput();//call base class writeOutput method
		System.out.println("Assignment 1 : " + assignment1);
		System.out.println("Assignment 2 : " + assignment2);
		System.out.println("Practical work  : " + practicalWork);
		System.out.println("Final exam : " + finalExam);
		System.out.println("Overall mark : " + getOverallScore());
		System.out.println("Grade : " + getGrade(overall)); //call getGrade method in base class
		System.out.println("");
	}
	
	//display output method in String type
	//super key word inherit the writeOutputStr method in base class
	/**
	 * This method is used to return the details of coursework student including base class varaibles
	 * (title, full name, date of birth and studentID in String type) and its own variables assignment1, assignment2, 
	 * practicalWork, finalExam and call getOverallScore and getGrade method to get the overall mark and grade respectively         
	 * <p>
	 * Precondition: Nil<br>
	 * Postcondition: Return the detials of CourseWorkStudent object including base class variables.
	 * </p>  
	 * @return super.writeOutputStr() + "\n" + "Assignment 1 : " + assignment1 + "\n"   
			   + "Assignment 2 : " + assignment2 + "\n" + "Practical work  : " + practicalWork
			   + "\n" + "Final exam : " + finalExam + "\n" + "Overall mark : " + getOverallScore()
			   + "\n" + "Grade : " + getGrade(overall) + "\n" Return student's details
	 */
	public String writeOutputStr() {
		
		return(super.writeOutputStr() + "\n" + "Assignment 1 : " + assignment1 + "\n"   
			   + "Assignment 2 : " + assignment2 + "\n" + "Practical work  : " + practicalWork
			   + "\n" + "Final exam : " + finalExam + "\n" + "Overall mark : " + getOverallScore()
			   + "\n" + "Grade : " + getGrade(overall) + "\n");
	}
	
	//New addition 
	//previously has no this method
	//the code to set mark for student was in the Client class
	public void setData(String line)
	{
		String[] data = line.split(",");
		long studentID = Long.parseLong(data[0]);
		this.assignment1 = Integer.parseInt(data[1]);
		this.assignment2 = Integer.parseInt(data[2]);
		this.practicalWork = Integer.parseInt(data[3]);
		this.finalExam = Integer.parseInt(data[4]);
	}
	
}
