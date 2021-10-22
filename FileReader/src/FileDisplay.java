import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileDisplay {
  
	public static Scanner input = null;  
	
	public static void main(String args[]) {
	  
	  Scanner scnr = new Scanner(System.in);
	  boolean run = true;
	  String choice;
	  
	  while(run) {
		  
		  System.out.println("1. MLB Teams\n2. NBA Teams\n3. NFL Teams\n4. NHL Teams");
		  System.out.println("Enter a number for the corresponding teams or \"0\" to quit");
		  choice = scnr.nextLine();
		  
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
  
  public static void printTeams(String teams) {
	  System.out.println(teams + "\n");
	  
	  try {
		  input = new Scanner(new FileInputStream(teams + ".txt"));
	  }
	  catch(FileNotFoundException e) {
		  System.out.println("Problem opening file");
		  return;
	  }
	  
	  while(input.hasNext()) {
		  System.out.println(input.nextLine());
	  }
	  
	  System.out.println();
  }
}

