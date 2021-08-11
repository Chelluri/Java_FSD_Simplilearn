package com.lockedme;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LockedMeProject {
	
		static final String folderpath = "/home/saichelluriredi/Phase1_Project";
	
/** Main that Method that displays menu
 * 
 * @param args
 */
	public static void main(String[] args)
	{
	// Variable Declaration
		Scanner obj = new Scanner(System.in);
		char choice;
		int ch;
// Use the Do and While loop to allow the Menu to be displayed again
		do {
			
			
	// Display Menu
		
		displayMenu();
		System.out.println("Enter your Choice :");
		ch = obj.nextInt();
		switch(ch)
		{
		case 1 : getAllFiles();
		         break;
		         
		case 2 : createAndWritefiles();
		          break;
		         
		case 3 : deleteFile();
		          break;
		         
		case 4 : searchFile();
		          break;
		          
		case 5 : System.exit(0);
		          break;
		default : System.out.println("Invalid Option");
		          break;
		}
		System.out.println("Do You Want To Continue to the Display Menu(Y/N)");
		 choice = obj.next().charAt(0);
		  
		} while(choice == 'Y'|| choice == 'y');
		obj.close();
					}
		// TODO Auto-generated method stub
	
	public static void displayMenu()
	{
		System.out.println("****************************************************");
		System.out.println("\t\t Company Lockers Pvt. Ltd");
		System.out.println("****************************************************");
		System.out.println("1. Display All Files");
		System.out.println("2. Add New File");
		System.out.println("3. Delete A File");
		System.out.println("4. Search a File");
		System.out.println("5. Exit");
		System.out.println("****************************************************");
			
	}
		
	public static void getAllFiles()
		{
		// Get File Names
List<String> fileNames = FileManager.getAllFiles(folderpath);
//Sorting Files in the ascending order
Collections.sort(fileNames);
for(String f:fileNames)
System.out.println(f);
	}

	
 public static void createAndWritefiles()
{
// Variable Declaration
Scanner obj = new Scanner(System.in);
String fileName;
int linesCount;
List<String> content = new ArrayList<String>();
// Read filename from the User
System.out.println("Enter file Name: ");
fileName=obj.nextLine();
// Read No of Lines from the User
System.out.println("Enter Numbe of Lines in the File: ");
linesCount=Integer.parseInt(obj.nextLine());
// Read lines from the User
for(int i=1; i<=linesCount; i++)
{
System.out.println("Enter line "+i+":");
content.add(obj.nextLine());
}
// Save the content into the File
boolean isSaved = FileManager.createFileAndWrite(folderpath, fileName, content);

if(isSaved)
System.out.println("File and data saved successfully");
else
System.out.println("Some error occurued. Please contact the admin@Locked Me Project");
//Close the Scanner Object

}
	
	//Code for deleting a file
 public static void deleteFile()
 {
		
String fileName;
Scanner obj = new Scanner(System.in);
System.out.println("Enter the file Filename to be deleted: ");
fileName = obj.nextLine();
boolean isDeleted = FileManager.deleteFile(folderpath, fileName);
if(isDeleted)
System.out.println("File deleted Successfully");
else
System.out.println("Either File not there or some access issue");
 }
 git 
 public static void searchFile()
 {		
		String fileName;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the file Filename to be Searched: ");
		fileName = obj.nextLine();
		boolean isFound = FileManager.searchFile(folderpath, fileName);
		if(isFound)
			System.out.println("File is present in the Folder ");
		else
			System.out.println("File is not present in the Folder");
	}
 
 
}