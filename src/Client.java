//Title     : FT MUR T221 ICT167 C – Assignment 2 (Student class)
//Author    : Tee Yee Kang
//Date      : 30/Jul/2021
//File Name : FTC-34315323-Assignment 02
//Purpose  	: The client class allowed user to create either CourseWorkStudent or ResearchStudent object. User here
//  		  read the value in the csv.file to create the research or course work student instead of keyboard value.
// 			  The client class also contains several methods for user to conduct some tasks. The program will keep executing
//            until user choose to exit the program. The program can also handle invalid input value by displaying some error 
//            message instead of crash the program.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author      TeeYeeKang    yeekang88 @ gmail.com
 * @version     13.0.2          
 */

public class Client {

	//declare static Scanner to read keyboard input
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//display student information
		studentInfo();
		
		//declare variables
		String fileName = "";
		boolean valid = false;
		int opt = -1;
		
		do{
			try {
				
				//set valid to true
				valid = true;
				
				//ask for user's choice between courseWorkStd / researchStd
				//keep asking until user entered a valid choice
				System.out.print("Enter 0 for coursework student / 1 for research student: ");
				opt = input.nextInt();
				System.out.print("\n");
			
				//declare file name based on user's option
				if(opt == 0) {
					fileName = "coursework.csv";
					System.out.println("---< Coursework student >---"); //just some simple output after user input
					//break;
				}else if(opt == 1) {
					fileName = "research.csv";
					System.out.println("---< Research student >---");
					//break;
				}else { 
					System.out.println("Invalid option"); //if user entered a valid input
					valid = false;
				}
			//catch InputMismatchException when user enterd non-numerical option for type of student
			//display error message and terminate the program
			}catch(InputMismatchException e) {
				System.out.println("\nOption must be numeric value");
				//valid = false;
				System.exit(0);
			}
		}while(!valid);
		
		//declare ArrayList to store objects
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		try {
			//create instance of File and Scanner to read value from file
			Scanner file = new Scanner(new File("students.csv"));
	
			//check if there is anymore line in file
			//read and print line from file
			while(file.hasNextLine()) {
				
				//retrieve data from student.csv file
				String line = file.nextLine();
				//split each values by comma and store into an array
				String[] data = line.split(","); 
				//retreive all value
				String type = data[0];	
				String title = data[1];
				String firstName = data[2];
				String lastName = data[3];
				long studentID = Integer.parseInt(data[4]); //convert String value into long
				int day = Integer.parseInt(data[5]);		//convert String value into int
				int month = Integer.parseInt(data[6]);
				int year = Integer.parseInt(data[7]);
				
				//create correspond student object based on user's option
				if(opt == 0) {
					if(type.equals("coursework")){
						//create CourseWorkStudent object by using the overload constructor with all parameters
						//all requied marks set as 0 first
						studentList.add(new CourseWorkStudent(title,firstName,lastName,studentID,day,month,year,0,0,0,0));
					}
				}else {
					//create ResearchStudent object by using the overload constructor with Student class variables only
					//The reason for using different constructors is just to test that all constructors are work
					if(type.equals("research")){
						studentList.add(new ResearchStudent(title,firstName,lastName,studentID,day,month,year));
					}
				}
			}//end of while loop
		//catch FileNotFoundException if file not found
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0); 
		}
		
		//menu - main controller for all tasks
		process(studentList,opt);
	
	}//end of main class
	
	//methods
	//task 2 - The object we created previously have no marks yet (set as 0 for all marks). Here read value
	//         from particular file to set all marks for CourseWorkStudent or ResearchStudent object 
	//         Arguments required a Student type ArrayList and a numeric value with int type
	/**
	* This method is used to read the value from the student.csv file to create CourseWorkStudent or ResearchStudent object<br>
	* based on user's option     
	** <p>
	* Precondition - Pass in a Student type ArrayList and an option with int value.<br>
	* Postcondition - Create either CourseWorkStudent or ResearchStudent object and store it into the ArrayList by reading<br>
	*   			  all values from the student.csv file.
	* </p>
	* @param studentList An ArrayList of type Student
	* @param opt User's option on CourseWorkStudent or ResearchStudent
	*/
	public static void readMarks(ArrayList<Student> studentList, int opt) {
		
		//declare counter for the used of ArrayList index
		int counter = 0;
		
		//deal with course work student
		if(opt == 0){
			try {
				//create instance of File and Scanner to read value from file coursework.csv
				Scanner courseworkFile = new Scanner(new File("coursework.csv"));
				
				//check if there is anymore line in file
				//read and print line from file
				while(courseworkFile.hasNextLine()) {
					
					//New addition - set marks for student
					//retrieve data from coursework.csv file
					String courseworkLine = courseworkFile.nextLine();
					
					//set marks for coursework students
					((CourseWorkStudent)studentList.get(counter)).setData(courseworkLine);
					
					//Previous working
					/*
					//retrieve data from coursework.csv file
					String courseworkLine = courseworkFile.nextLine();
					//split each values by comma and store into an array
					String[] courseworkMarks = courseworkLine.split(",");
					//retreive all value
					String courseworkStdID = courseworkMarks[0];
					double assignment1 = Integer.parseInt(courseworkMarks[1]);
					double assignment2 = Integer.parseInt(courseworkMarks[2]);
					double practical = Integer.parseInt(courseworkMarks[3]);
					double exam = Integer.parseInt(courseworkMarks[4]);
			
					//set marks for coursework students
					if(studentList.get(counter) instanceof CourseWorkStudent){
						((CourseWorkStudent)studentList.get(counter)).setAssignment1(assignment1);
						((CourseWorkStudent)studentList.get(counter)).setAssignment2(assignment2);
						((CourseWorkStudent)studentList.get(counter)).setPracticalWork(practical);
						((CourseWorkStudent)studentList.get(counter)).setFinalExam(exam);
					}*/

					//New addition
					//incease counter by 1 for next ArrayList object
					counter++;
				}//end of while loop
				
			}catch(FileNotFoundException e) { 			//catch FileNotFoundException if file not found
				System.out.println("File not found");
				System.exit(0);
			}
		//deal with research student
		}else {
			try {
				//create instance of File and Scanner to read value from file research.csv
				Scanner researchFile = new Scanner(new File("research.csv"));
				
				//check if there is anymore line in file
				//read and print line from file
				while(researchFile.hasNextLine()) {
					
					//New addition - set marks for student
					//retrieve data from research.csv file
					String researchLine = researchFile.nextLine();
					
					//set marks for research students
					((ResearchStudent)studentList.get(counter)).setData(researchLine);
					
					//Previous working
					/*
					//retrieve data from research.csv file
					String researchLine = researchFile.nextLine();
					String[] researchMarks = researchLine.split(",");
					String researchStdID = researchMarks[0];
					double oral = Double.parseDouble(researchMarks[1]);
					double thesis = Double.parseDouble(researchMarks[2]);
					
					//set marks for research students
					((ResearchStudent)studentList.get(counter)).setOralPresentation(oral);
					((ResearchStudent)studentList.get(counter)).setFinalThesis(thesis);
				
					//New addition
					//incease counter by 1 for next ArrayList object*/
					counter++;
				}//end of while loop
				
			}catch(FileNotFoundException e) {
				System.out.println("File not found");
				System.exit(0);
			}
		}
		
		//print successful message
		System.out.println("");
		System.out.println("Success - read all marks");
	}
	
	//task 3 - Remove student from ArrayList by entered the studentID.
	//		   To complete this task, user have to enter yes in the confirmation query, else program will
	//         not remove any student from the ArrayList. The program can also handle error such as invalid input 
	//         and non existing student.    
	//         Argument required a Student type ArrayList
	/**
	* This method is used to remove object from the ArrayList by enter the particular studentID      
	** <p>
	* Precondition - Pass in a Student type ArrayList .<br>
	* Postcondition - The student/object successfully removed from the ArrayList if the studentID is found and <br>
	*                 user entered yes in the confirmation query. Else, program will ignore this transaction.
	* </p>
	* @param studentList An ArrayList of type Student
	*/
	public static void removeStd(ArrayList<Student> studentList) {
		
		//declare boolean for display output purpose
		boolean isFound = false;
		
		try {
			//prompt for studentID to be remove
			System.out.print("Enter the studentID of student you want to remove: ");
			long stdToRemove = input.nextInt();
			//double confirm with the user
			
			System.out.print("Confirm remove student " + stdToRemove + " ? Yes/No:  ");
			String opt = input.next();
		
			//remove student/object
			if(opt.equalsIgnoreCase("yes")) {
				//loop through to find the student
				for(int idx = 0; idx<studentList.size();idx++) {
					//find same studentID
					if(studentList.get(idx).getStudentID() == stdToRemove) {
						studentList.remove(idx); //use the pre-define method -remove to remove std if found
						isFound = true;
						break;   //break the loop once the studentID is found
					}
				}
			
				//display successful or not found message
				System.out.println("");
				if(isFound == true) {
					System.out.println("Student " + stdToRemove + " successfully removed");
				}else {
					System.out.println("Student " + stdToRemove + " not found");
				}
			}else if (opt.equalsIgnoreCase("no")) {
				System.out.println("\nSee you then ~");
			}else {
				throw new InputMismatchException(); //any option apart from yes or no will throw InputMismatchException
			}
		//catch the InputMismatchException if the user enters a non-numerical studentID
		}catch(InputMismatchException ex) {
			System.out.println("\nInvalid option !");
		}
	}
	
	//task 4 - Display all the details of CourseworkStudent or ResearchStudent.
	//         Pass in the Student type ArrayList, inside the for-each loop will call the writeOutput method
	//         in order to print the details of CourseworkStudent or ResearchStudent.
	/**
	* This method is used to output all the detials of CourseworkStudent or ResearchStudent    
	** <p>
	* Precondition - Pass in a Student type ArrayList .<br>
	* Postcondition - The program successfully display all the detials of CourseworkStudent or ResearchStudent <br>
	*                 including student's identification, marks, grade, etc.
	* </p>
	* @param studentList An ArrayList of type Student
	*/
	public static void display(ArrayList<Student> studentList) {
		
		//print output
		System.out.println("");
		//for-each loop 
		for(Student std : studentList) {
			std.writeOutput();  //call the writeOutput method to display all output
		}
	}
	
	//task 5 - Calculate the overall marks of all CourseworkStudent or ResearchStudent in the ArrayList.
	//         This method is to find the individual overall mark of particular student by passing in the
	//         Student type ArrayList, option of which type of student with int value and the index of particular student.
	/**
	* This method is used to to find the individual overall mark of particular student for furthur task 5 calculation    
	** <p>
	* Precondition - Pass in a Student type ArrayList, option of which type of student with int value and the index of particular student.<br>
	* Postcondition - The program will calculate the student's overall mark by calling the getOverallScore() method<br>
	*                 and return the overall mark.
	* </p>
	* @param studentList An ArrayList of type Student
	* @param opt Option of which type of student
	* @param idx Index of the student/object to be dealing with
	* @return overallMarks Return the overall mark of the particular student/object
	*/
	public static double getIndividualOverall(ArrayList<Student> studentList, int opt, int idx){
		
		//declare variables to be return
		double overallMarks = 0;
		
		//opt 0 is CourseWorkStudent, else/1 is ResearchStudent. Validation of opt check are done in the main class
		if(opt == 0) {
			//call the getOverallMarks in child class to calculate and return the overall marks
			overallMarks = ((CourseWorkStudent)studentList.get(idx)).getOverallScore();
		}else {
			overallMarks = ((ResearchStudent)studentList.get(idx)).getOverallScore();
		}
		return overallMarks;
	}
	
	//task 6 - Get average overall mark of all students/objects in the ArrayList
	//         Arguments required Student type ArrayList and option of which type of student with int value.
	/**
	* This method is used to to find the average overall mark of all students in the ArrayList   
	** <p>
	* Precondition - Pass in a Student type ArrayList and the option of which type of student with int value.<br>
	* Postcondition - The for loop will keep calling the getIndividualOverall() method to get each individual<br>
	*                 overall mark and store in the running total until reach the ArrayList size. Lastly,<br>
	*                 return the running total.
	* </p>
	* @param studentList An ArrayList of type Student
	* @param opt Option of which type of student
	* @return avgOverallMark Return the overall mark of all CourseworkStudent or ResearchStudent.
	*/
	public static double avgOverallMark(ArrayList<Student> studentList, int opt) {
		
		//declare variables
		double total = 0;
		double avgOverallMark = 0;
		
		//calculation of total
		for(int idx=0; idx<studentList.size(); idx++) {
			total += getIndividualOverall(studentList, opt, idx);  //call getIndividualOverall() to calculate the total
		}
		
		//calculate average overall mark
		avgOverallMark = total / studentList.size();
		
		return avgOverallMark;
	}
	
	//task 5 controller - Calculate + display individual overall mark and grade 
	//                    Arguments required Student type ArrayList and option of which type of student with int value.
	/**
	* This method is the controller of task 5. 
	** <p>
	* Precondition - Pass in a Student type ArrayList and the option of which type of student with int value.<br>
	* Postcondition - The method will find and output the individual overall mark and grade of of all CourseworkStudent or ResearchStudent <br>
	* </p>
	* @param studentList An ArrayList of type Student
	* @param opt Option of which type of student
	*/
	public static void outputOverallAndGrade(ArrayList<Student> studentList, int opt) {
		
		//declare variables for working storage
		double overall = 0; //this overall is to displaying all individual student's overall marks 
		String grade = null; //Individual student grade

		//display output for individual overall mark
		System.out.println("");
		System.out.println("StudentID  | Overall_Marks | Grade");
		System.out.println("--------------------------------------");
		
		for(int idx=0; idx<studentList.size(); idx++) {
				
			//get individual overall score and grade first
			overall = getIndividualOverall(studentList, opt, idx);
			grade = studentList.get(idx).getGrade(overall);
			//find for the particular studentID for displaying output
			long studentID = studentList.get(idx).getStudentID();
				
			//display individual overall marks and grade 
			System.out.println("   "+studentID + "\t\t" + overall + "\t\t" + grade);
		}
	}
	
	//task 6 - Determine and display how many coursework or research students obtained an overall mark 
	//         equal to or above the average overall mark and how many obtained an overall mark below the 
	//         average overall mark
	//         Arguments required Student type ArrayList and option of which type of student with int value.
	/**
	* This method is to find number of student obtained an overall mark equal/above the average overall <br>
	* mark and the number of student obtained an overall mark below the average overall mark       
	** <p>
	* Precondition - Pass in a Student type ArrayList and the option of which type of student with int value.<br>
	* Postcondition - The first part of the method will get and output the total number of student,<br> 
	*                 average overall mark and grade of all students <br>
	*                 Then the for loop will calculate the number of student obtained an overall mark <br>
	*                 equal to or above the average overall mark and how many obtained an overall mark below the<br>
	*                 average overall mark.
	* </p>
	* @param studentList An ArrayList of type Student
	* @param opt Option of which type of student
	*/
	public static void aboveOrBelowOverall(ArrayList<Student> studentList, int opt) {
		
		//declare variables for working storage
		double avgOverall = avgOverallMark(studentList, opt); //get average overall mark of all student
		int equalOrAbove = 0;
		int below = 0;
		double averageOverall = 0; //average overall mark of all students
		String avgOverallMarkGrade = null; //average grade of all students
		
		//calculate and display average overall mark of all students
		averageOverall = avgOverallMark(studentList, opt);
		//find grade for average overall mark of all students
		avgOverallMarkGrade = studentList.get(0).getGrade(averageOverall);
		//display output
		System.out.println("\n-> Total number of student : " + studentList.size());
		System.out.println("-> Average Overall Mark : " + averageOverall);
		System.out.println("-> Grade : " + avgOverallMarkGrade);

		//calculate the number of student equal/above or below the average overall mark
		for(int idx=0; idx<studentList.size(); idx++) {
			
			//deal with coursework student
			if(opt == 0) {
				if(((CourseWorkStudent)studentList.get(idx)).getOverallScore() >= avgOverall) {
					equalOrAbove ++;
				}else {
					below ++;
				}
			//deal with research student
			}else {  			
				if(((ResearchStudent)studentList.get(idx)).getOverallScore() >= avgOverall) { //deal with reasearch student
					equalOrAbove ++;
				}else {
					below ++;
				}
			}
		}
		
		//display output
		System.out.println("");
		System.out.println(equalOrAbove + " students obtained an overall mark equal to or above the average overall mark of " + avgOverall);
		System.out.println(below + " students obtained an overall mark below the average overall mark of " + avgOverall);
	}
	
	//task 7 - Get studentID from user and display the student's details. The program is able to handle some error
	//         such as non existing student/object.
	//         Arguments required Student type ArrayList
	/**
	* This method is used to display the details of CourseworkStudent or ResearchStudent based on the studentID       
	** <p>
	* Precondition - Pass in a Student type ArrayList.<br>
	* Postcondition - The program will prompt user to enter the studentID. <br>
	*                 Then the for loop will find for the same studentID object and display the details of <br>
	*                 the particular student by calling the writeOutput method.
	* </p>
	* @param studentList An ArrayList of type Student
	*/
	public static void studentIDToGetDetails(ArrayList<Student> studentList){ 
		
		//declare boolean for display output purpose
		boolean isFound = false;
		
		try {
			//ask user for studentID
			System.out.print("Enter student number to retrieve the student details: ");
			long stdToRetrieve = input.nextInt();

			//loop through to find the student/object
			for(int idx = 0; idx<studentList.size();idx++) {
				//find same studentID
				if(studentList.get(idx).getStudentID() == stdToRetrieve) {
					System.out.println("\nStudent details : ");
					System.out.println("------------------------");
					//call writeOutput() method to display student's details
					studentList.get(idx).writeOutput();
					isFound = true;
					break;
				}
			}
		
			//if no same studentID object is found
			if(!isFound) {
				System.out.println("\nStudent not found");
			}
		//catch the InputMismatchException if the user enters a non-numerical studentID
		}catch(InputMismatchException exc) {			//
			System.out.println("\nInvalid studentID");
		}
	}
	
	//task 8 - Get name to display student's details. The program is able to handle some error
	//         such as non existing student/object.
	//	       Arguments required Student type ArrayList
	/**
	* This method is used to display the details of CourseworkStudent or ResearchStudent based on student's first and last name     
	** <p>
	* Precondition - Pass in a Student type ArrayList.<br>
	* Postcondition - The program will prompt user to enter the student's first name and last name. <br>
	*                 Then the for loop will find for the same student full name object and display the details of <br>
	*                 the particular student by calling the writeOutput method.
	* </p>
	* @param studentList An ArrayList of type Student
	*/
	public static void studentNameToGetDetails(ArrayList<Student> studentList) {
		
		//declare boolean for display output purpose
		boolean isFound = false;
		
		//prompt user to entered student's first name and last name
		System.out.println("Enter student's name to retrieve the student details ");
		System.out.print("Enter student's first name:  ");
		String firstName = input.next();
		System.out.print("Enter student's last name:  ");
		String lastName = input.next();
		//concatenate firstName and lastName
		String fullName = firstName + " " + lastName;
		
		//search for the object
		for(int idx = 0; idx<studentList.size();idx++) {
			//find and display the object with same student name, case not sensative
			if(studentList.get(idx).getFullName().equalsIgnoreCase(fullName)) {
				System.out.println("\nStudent details : ");
				System.out.println("------------------------");
				studentList.get(idx).writeOutput();
				isFound = true;
			}
		}
		//if no same name object found
		if(!isFound) {
			System.out.println("\nStudent not found");
		}
	}
	
	//task 9 - Sort ArrayList in ascending order of the studentID by using the Bubble sort
	//         One of the reasons why I choose bubble sort method to sort the ArrayList is because
	//		   bubble sort is easier to understand compare to insertion sort and selection sort.
	//         This is better for me and even other developer who looking at my code.
	//         In addition, the studentID given in the csv file is already almost sorted. 
	//         Therefore, bubble sort is the most effective method to sort the ArrayList in ascending order.
	/**
	* This method is used to sort ArrayList in ascending order of the studentID by using the Bubble sort
	** <p>
	* Precondition - Pass in a Student type ArrayList.<br>
	* Postcondition - This method will sort the passed in ArrayList in ascending order of the studentID by using the Bubble sort. <br>
	*                 The for loop will swap the positon of the objects if the previous studentID is greater than the latter.
	* </p>
	* @param studentList An ArrayList of type Student
	*/
	public static void sort(ArrayList<Student> studentList){
		
		boolean swap = true;
		while (swap) {
			swap = false;
			for (int idx = 1; idx < studentList.size(); idx++) {
				//Check if the previous studentID is greater than the latter
				if (studentList.get(idx-1).getStudentID() > (studentList.get(idx).getStudentID())){
					// swap the student 
					Student temp1 = studentList.get(idx-1);
					Student temp2 = studentList.get(idx);
					studentList.set(idx, temp1);
					studentList.set(idx-1, temp2);
					swap = true;
				}
			}
		}
	}
	
	//task 9 - main controller of task 9 
	//         Display sorted ArrayList
	//         This method will first sort the ArrayList by calling the sort() method, then display the sorted ArrayList.
	/**
	* This method is used to display the sorted ArrayList
	** <p>
	* Precondition - Pass in a Student type ArrayList.<br>
	* Postcondition - This method will sort the passed in ArrayList in ascending order of the studentID by <br>
	*                 calling the sort() method. Then display the sorted ArrayList.
	* </p>
	* @param studentList An ArrayList of type Student
	*/
	public static void displaySortedArrayList(ArrayList<Student> studentList) {
		
		//sort ArrayList first
		sort(studentList);
		
		//display sorted ArrayList
		System.out.println("\n----Sorted student list----");
		display(studentList);
	}

	//task 10 - Output the sorted ArrayList into a .csv file 
	/**
	* This method is used to output the sorted ArrayList into the sortedArrayListOutput.csv file 
	** <p>
	* Precondition - Pass in a Student type sorted ArrayList.<br>
	* Postcondition - The sorted ArrayList will be wrote into the .csv file and can be seen in the .csv file.
	* </p>
	* @param sortedStudentList An sorted ArrayList of type Student
	*/
	public static void storeSortedArrayList(ArrayList<Student> sortedStudentList) {

		//declare outputStream instance of PrintWriter
		PrintWriter outputStream = null;	
		
		try {
			//open outputFile and connect to object outputStream
			//create the outputStream object here
			outputStream = new PrintWriter("sortedArrayListOutput.csv");
			
			//for-each loop to retrieve the elements in ArrayList
			//and print into the csv file
//			for(Student content : sortedStudentList) {
//				//Print the content to outputStream
//				outputStream.println(content);
//		}
			//print the sorted ArrayList into the sortedArrayListOutput.csv file
			for(int idx=0; idx<sortedStudentList.size(); idx++) {
				outputStream.println(sortedStudentList.get(idx).writeOutputStr());
			}
			
		}catch(FileNotFoundException ex) {
			System.out.println("File not exist");
			System.exit(0);
		}
		
		//close outputStream
		outputStream.close();
		
		//display success msg
		System.out.println("\nSuccessfully stored in csv file");
	}
	
	//display menu and prompt for user choice
	//the menu will keep executing after each task is completed until user entered task 1 to exit the program
	/**
	* This method is to display the menu and ask for user's choice.     
	** <p>
	* Precondition - Nil<br>
	* Postcondition - Prompt user to enter a choice and return user's choice.
	* </p>
	* @return choice Return user's choice
	* @throws Exception Choice must be numeric value and between 1-10
	*/
	public static int menu() throws Exception{
		System.out.println("\n---------< Menu >----------");
		System.out.println("[1] - Exit program!  ");
		System.out.println("[2] - Read marks");
		System.out.println("[3] - Remove student ");
		System.out.println("[4] - Output of ArrayList");
		System.out.println("[5] - Overall marks and grade");
		System.out.println("[6] - Above / Below average overall mark");
		System.out.println("[7] - StudentID to find student's details");
		System.out.println("[8] - Student name to find student's details");
		System.out.println("[9] - Sort array in ascending array");
		System.out.println("[10] - Output sorted ArrayList to CSV file");
		System.out.print("\nEnter your choice : ");
		int choice = Integer.parseInt(input.next());
		return choice;
		
	}//end of method
	
	//Main controller that call all 10 different tasks based on user's choice
	//the menu will keep executing after each task is completed until user entered task 1 to exit the program
	//This method is able to handle some error input such as non-numerical value and invalid input.
	//boolean valid and validOrder is to controll the order of execution
	//the user need to execute task 2 to read student's mark first so that he/she
	//can perform task 3, 5 and 6. Similar to task 9 and 10. 
	/**
	* This method is the main controller which call and execute task according to user's choice     
	** <p>
	* Precondition -  Pass in a Student type ArrayList and the option of which type of student with int value.<br>
	* Postcondition - Perform the task selected by user.
	* </p>
	* @param studentList An ArrayList of type Student
	* @param num Option of which type of student
	*/
	public static void process(ArrayList<Student> studentList, int num){
		
		//declare variables
		int option = 0;
		boolean valid = false;		  //use for the order of execution
		boolean validOrder = false; //use for the order of execution
		
		do
		{
			try{
				option = menu();
				switch(option)
				{
				case 1 : System.out.println("\nThank you Bye!!");
						 break;
				case 2 : readMarks(studentList,num);   //once task 2 is executed, boolean validOverall will become true
						 validOrder = true;  
						 break;
				case 3 : if(validOrder) {
							 removeStd(studentList);  //task 3 can only be executed when validOrder is true 
						 }else {
							 System.out.println("\nPlease execute task 2 to read the marks first");
						 }
						 break;
				case 4 : display(studentList);
						 break;
				case 5 : if(validOrder) {
							outputOverallAndGrade(studentList, num);  	//task 5 & 6 can only be executed when validOrder is true 
						 }else {										//else return the error message
							 System.out.println("\nSelect task 2 to read the marks first");
						 }
						 break;
				case 6 : if(validOrder) {
							aboveOrBelowOverall(studentList, num);
						 }else {
							 System.out.println("\nMarks not read yet, select task 2 to read the marks first");
						 }
					 	 break;
				case 7 : studentIDToGetDetails(studentList);
					 	 break;
				case 8 : studentNameToGetDetails(studentList);
					 	 break;
				case 9 : displaySortedArrayList(studentList);   //once task 9 is executed, boolean valid will become true
						 valid = true;
				 	 	 break;
				case 10 : if(valid) {							//task 10 can only be executed when valid is true 
							storeSortedArrayList(studentList);  //means task 9 has been executed
						}else {									//else return the error message
							System.out.println("\nArrayList not sorted yet. Select task 9 to sort first");
						}
			 	 	 	 break;
				default : System.out.println("\nInvalid option!");
				}
			}catch (Exception e) //if user enter non-numerical value
			{
				System.out.println("\nUse a numerical value !");
			}
		}while (option != 1);
	}
	
	//student information
	/**
	* This method is used display the student information      
	** <p>
	* Precondition - Nil.<br>
	* Postcondition - Display student information.
	* </p>
	*/
	public static void studentInfo() {
		System.out.println("Name				: Tee Yee kang" );
		System.out.println("StudentNo			: 34315323" );
		System.out.println("Mode Of Enrolment		: Full Time" );
		System.out.println("Tutor 				: Aaron Yeo" );
		System.out.println("Tutorial Attendence Day		: Friday" );
		System.out.println("Tutorial Attendence Time	: 1030-1230" );
		System.out.println("----------------------------------------------\n" );
	}//end of method
	
	
}//end of class

