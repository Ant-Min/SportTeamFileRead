import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileDisplay {
	public static Scanner input = null;  
	static Scanner scnr = new Scanner(System.in);
	
	public static void main(String args[]) {
	  
	  boolean run = true;
	  String choice;
	  
	  //while loop that keeps program running until user ends program
	  while(run) {
		  
		  System.out.println("1. MLB Teams\n2. NBA Teams\n3. NFL Teams\n4. NHL Teams");
		  System.out.println("Enter a number for the corresponding teams or \"0\" to quit");
		  choice = scnr.nextLine();
		  
		  //switch statement for options user has. Most options refer to printTeams method
		  switch(choice) {
		  	case "0":
		  		System.out.println("Goodbye");
		  		run = false;
		  		break;
		  	case "1":
		  		printTeams("MLB Teams");
		  		break;
		  	case "2":
		  		printTeams("NBA Teams");
		  		break;
		  	case "3":
		  		printTeams("NFL Teams");
		  		break;
		  	case "4":
		  		printTeams("NHL Teams");
		  		break;
		  	default:
		  		System.out.println("Not a valid option.");
		  		break;
		  }
	  }
	  	  
  }
  
  //printTeams is a method where the list of sport teams are printed out to the console. The user can then search for a particular team or area
  public static void printTeams(String teams) {
	  
	  ArrayList<String> list = new ArrayList<String>(); //ArrayList to hold team names
	  boolean notFound = true; //boolean to test if user entered an existing team
	  String location; //String where user will enter team name or city
	  
	  System.out.println("You chose " + teams + "\n");
	  
	  //try-catch block to read from text file of teams
	  try {
		  input = new Scanner(new FileInputStream(teams + ".txt"));
	  }
	  catch(FileNotFoundException e) {
		  System.out.println("Problem opening file");
		  return;
	  }
	  
	  //displays teams to user
	  while(input.hasNextLine()) {
		  System.out.println(input.nextLine());		  
	  }
	  
	  //Working with only one FileInputStream caused several bugs and other issues, so I reloaded the file
	  Scanner input2;
	  try {
		  input2 = new Scanner(new FileInputStream(teams + ".txt"));
	  } catch (FileNotFoundException e) {
		  System.out.println("Problem opening file");
		  return;
	  }
	  
	  //the new file adds the teams to an ArrayList
	  while(input2.hasNextLine()) {
		  list.add(input2.nextLine());
	  }
	  
	  System.out.println("Enter location or team name (proper punctuation), otherwise enter \"0\" to return to menu.");
	  
	  location = scnr.nextLine();
	  
	  //first if statement prevents the program from crashing because of a nextLine error. Program will return to menu or search for a team depending on user input
	  if(location.equals(null) || location.equals(" ")|| location.equals("")) {
		  System.out.println("Nothing was entered. Returning to menu.");
		  return;
	  }
	  else if(location.equals("0")) {
		  return;
	  }
	  else {
		  for(int i = 0; i < list.size(); i++) {
			  if(list.get(i).contains(location)) {
				  notFound = false;
				  System.out.println(list.get(i));
			  }
		  }
	  }
	  
	  if(notFound) {
		  System.out.println("No teams found");
	  }
	  
	  System.out.println();
	  
	  input.close();
	  input2.close();
  }
}

