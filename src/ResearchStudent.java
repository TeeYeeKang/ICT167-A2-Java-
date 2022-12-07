//Title     : FT MUR T221 ICT167 C – Assignment 2 (Student class)
//Author    : Tee Yee Kang
//Date      : 30/Jul/2021
//File Name : FTC-34315323-Assignment 02
//Purpose  	: There are two different type of student which is CourseWorkStudent and ResearchStudent.
//			  ResearchStudent class is the child class of Student class. Therefore, it required variables in base class
//            and its own variables to create object. User can also create student class object without
//			  any arguments (default value) by using the constructor with no parameter. 
//			  There are appropriate getter & setter method for user to retrieve or set student object value.
//     	      It can also use the methods in the base class.

/**
 * @author      TeeYeeKang    yeekang88 @ gmail.com
 * @version     13.0.2        
 */

public class ResearchStudent extends Student {

	//instance variables
	/**
	 * The double oral presentation marks
	 */
	private double oralPresentation;
	/**
	 * The double final thesis marks
	 */
	private double finalThesis;
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
	 * Default Constructor of ResearchStudent(child) class                          
	 * <p>
	 * This method is used to represent the default value of double oralPresentation, finalThesis, overall and String grade<br>
	 * </p>
	 * Precondition - Nil <br>
	 * Postcondition - A ResearchStudent object is created with all the default value including the value of base class<br>
	 * 				   and its own variables.
	 */
	public ResearchStudent() {
		super(); //call default constructor of super class Student
		oralPresentation = 0;
		finalThesis = 0;
		overall = 0;
		grade = "No grade";
	}
	
	//constructor overload - different arguments
	//takes in the variables of Student class only
	/**
	 * Overloading Constructor of ResearchStudent(child) class                          
	 * <p>
	 * This method is used to create ResearchStudent object without all the marks<br>
	 * </p>
	 * Precondition - Takes in Student object's variables. The value of title, firstName and lastName must be a String type,<br>
	 *  			  data type of studentID is long.<br>
	 * 				  date of birth need to be int type(divided into 3 components e.g. day/month/year)<br>
	 * Postcondition - A ResearchStudent object is created with Student class variables only. 
	 * @param  InitialTitle Title of the student (e.g. Mr, Mrs, etc)
	 * @param  InitialFirstName First name of the student
	 * @param  InitialLastName Last name of the student
	 * @param  InitialStudentID Student's student number
	 * @param  InitialDOB_day Day of birth of the student
	 * @param  InitialDOB_month Month of birth of the student
	 * @param  InitialDOB_year Year of birth of the student
	 */
	public ResearchStudent(String InitialTitle, String InitialFirstName, String InitialLastName, 
			long InitialStudentID, int InitialDOB_day, int InitialDOB_month,int InitialDOB_year) {
		super(InitialTitle,InitialFirstName, InitialLastName,InitialStudentID,InitialDOB_day,InitialDOB_month,InitialDOB_year);	
	}
	
	//constructor overload - different arguments
	//takes in the value of ResearchStudent class only
	/**
	 * Overloading Constructor of ResearchStudent(child) class                          
	 * <p>
	 * This method is used to create ResearchStudent object with marks only and without the variables of Student class<br>
	 * </p>
	 * Precondition - Takes in only double type of oral presentation marks and final thesis mark.<br>
	 * Postcondition - A ResearchStudent object is created with all the marks only. 
	 * @param  InitialOralPresentation Oral presentation marks
	 * @param  InitialFinalThesis Final thesis marks 
	 */
	public ResearchStudent(double InitialOralPresentation, double InitialFinalThesis) {
		super(); //call default constructor of super class Student
		oralPresentation = InitialOralPresentation;
		finalThesis = InitialFinalThesis;
	}
	
	//constructor with all parameters
	//super key word will inherit the construtor with parameters in base class
	/**
	 * Constructor of ResearchStudent(child) class                          
	 * <p>
	 * This constructor is used to represent the value of String title, String firstName, String lastName, <br>
	 * int studentID, int day of birth, int month of birth, int year of birth, double InitialOralPresentation marks,
	 * and double InitialFinalThesis marks. Overall marks and grade not included because it has to be calculated.
	 * </p>
	 * Precondition - The value of title, firstName and lastName must be a String type, data type of studentID is long,<br>
	 * 				  date of birth need to be int type(divided into 3 components e.g. day/month/year)<br>
	 * 				  and double type of oral presentation marks and final thesis marks<br>
	 * Postcondition - A ResearchStudent object is created with the value of title, firstName, lastName, studentID,<br>
	 * 				   day of birth, month of birth, year of birth, oralPresentation and finalThesis. 
	 * @param  InitialTitle Title of the student (e.g. Mr, Mrs, etc)
	 * @param  InitialFirstName First name of the student
	 * @param  InitialLastName Last name of the student
	 * @param  InitialStudentID Student's student number
	 * @param  InitialDOB_day Day of birth of the student
	 * @param  InitialDOB_month Month of birth of the student
	 * @param  InitialDOB_year Year of birth of the student
	 * @param  InitialOralPresentation Oral presentation marks
	 * @param  InitialFinalThesis Final thesis marks
	 */
	public ResearchStudent(String InitialTitle, String InitialFirstName, String InitialLastName, 
			long InitialStudentID, int InitialDOB_day, int InitialDOB_month,int InitialDOB_year,
			double InitialOralPresentation, double InitialFinalThesis) {
		
		//call default constructor of super class Student and pass in the arguments
		super(InitialTitle,InitialFirstName, InitialLastName,InitialStudentID,InitialDOB_day,InitialDOB_month,InitialDOB_year);
		oralPresentation = InitialOralPresentation;
		finalThesis = InitialFinalThesis;
	}

	//getter and setter methods
	/**
	 * This method is used to get the oral presentation marks of research student(ResearchStudent object)                        
	 * <p>
	 * Precondition: oralPresentation is initialised at the Constructor <br>
	 * Postcondition: The oral presentation mark of the Student object is returned.
	 * </p>   
	 * @return oralPresentation Return the ResearchStudent object's oral presentation mark    
	 */
	public double getOralPresentation() {
		return oralPresentation;
	}

	/**
	 * This method is used to set the new oral presentation mark of research student(ResearchStudent object)                        
	 * <p>
	 * Precondition: Take in a new oral presentation mark of double value<br>
	 * Postcondition: The oral presentation mark of the ResearchStudent object is set.
	 * </p>   
	 * @param NewOralPresentation Oral presentation mark of ResearchStudent object      
	 */
	public void setOralPresentation(double NewOralPresentation) {
		oralPresentation = NewOralPresentation;
	}

	/**
	 * This method is used to get the final thesis marks of research student(ResearchStudent object)                        
	 * <p>
	 * Precondition: finalThesis is initialised at the Constructor <br>
	 * Postcondition: The final thesis marks of research student(ResearchStudent object) is returned.
	 * </p>   
	 * @return finalThesis Return the ResearchStudent object's final thesis mark    
	 */
	public double getFinalThesis() {
		return finalThesis;
	}

	/**
	 * This method is used to set the new final thesis mark of research student(ResearchStudent object)                        
	 * <p>
	 * Precondition: Take in a new final thesis mark of double value<br>
	 * Postcondition: The final thesis mark of the ResearchStudent object is set.
	 * </p>   
	 * @param NewFinalThesis Final thesis mark of ResearchStudent object      
	 */
	public void setFinalThesis(double NewFinalThesis) {
		finalThesis = NewFinalThesis;
	}
	
	//calculate the overall score of research student
	//return sum of oralPresentationMarks and finalThesisMarks but
	//oralPresentationMarks worth 20 marks so required futher calculation
	//finalThesisMarks worth 80% of the total overall marks
	/**
	 * This method is used to calculate the overall mark of research student(ResearchStudent object)                          
	 * <p>
	 * Precondition: Nil<br>
	 * Postcondition: Return the overall mark of student after the calcualtion is completed.
	 * </p>   
	 * @return overall Return the overall mark of research student (ResearchStudent object)     
	 */
	public double getOverallScore() {
		
		//calculate each mark
		double oralPresentationMarks = this.oralPresentation; //worth 20% and max score is 20 so no required futhur calculation
		double finalThesisMarks = this.finalThesis * 80 / 100;//worth 80%
		
		//calculate overall score
		overall = oralPresentationMarks + finalThesisMarks;
		return overall;
	}
	
	//display output method
	//display the details of research student including base class varaibles value and itw own marks and grade
	//super key word inherit the writeOutput method in base class
	/**
	 * This method is used to display the details of research student including base class variables
	 * (title, full name, date of birth and studentID), its own variables oralPresenation, finalThesis and 
	 * call getOverallScore and getGrade method to get the overall mark and grade respectively          
	 * <p>
	 * Precondition: Nil<br>
	 * Postcondition: Display the detials of ResearchStudent object including base class variables.
	 * </p>       
	 */
	public void writeOutput() {
		super.writeOutput();//call base class writeOutput method
		System.out.println("Oral presentation : " + oralPresentation);
		System.out.println("Final thesis : " + finalThesis);
		System.out.println("Overall score : " + getOverallScore()); 
		System.out.println("Grade : " + getGrade(overall)); //call getGrade method in base class
		System.out.println("");
	}
	
	//display output method in String type
	//super key word inherit the writeOutputStr method in base class
	/**
	 * This method is used to return the details of research student including base class varaibles
	 * (title, full name, date of birth and studentID in String type) and its own variables oralPresenation, finalThesis and 
	 * call getOverallScore and getGrade method to get the overall mark and grade respectively          
	 * <p>
	 * Precondition: Nil<br>
	 * Postcondition: Return the detials of ResearchStudent object including base class variables.
	 * </p>
	 * @return super.writeOutputStr() + "\n" + "Oral presentation : " + oralPresentation
				+ "\n" + "Final thesis : " + finalThesis + "\n" + "Overall score : " + getOverallScore()
				+ "\n" + "Grade : " + getGrade(overall) + "\n" Return student's details       
	 */
	public String writeOutputStr() {
		
		return (super.writeOutputStr() + "\n" + "Oral presentation : " + oralPresentation
				+ "\n" + "Final thesis : " + finalThesis + "\n" + "Overall score : " + getOverallScore()
				+ "\n" + "Grade : " + getGrade(overall) + "\n");
	}
	
	//New addition 
	//previously has no this method
	//the code to set mark for student was in the Client class
	public void setData(String line)
	{
		String[] data = line.split(",");
		long studentID = Long.parseLong(data[0]);
		this.oralPresentation = Integer.parseInt(data[1]);
		this.finalThesis = Integer.parseInt(data[2]);
	}
	
}
