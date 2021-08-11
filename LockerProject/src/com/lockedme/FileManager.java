package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	/**
	 * 
	 * @param folderpath
	 * @return
	 */
	
	
		 public static List<String> getAllFiles(String folderpath)
		{

		//Creating a file Object
		File f1 = new File(folderpath);

		//Getting all files into a File Array

		File[] listofFiles = f1.listFiles();


		//Declare a list to store file names
		List<String> filenames = new ArrayList<String>();
		for(File f:listofFiles)
		filenames.add(f.getName());
		//return the list
		return filenames;

		}
		 
		 
			public static boolean createFileAndWrite(String folderpath, String fileName, List<String> content)
			{
				try
				{
					File fl = new File(folderpath, fileName);
					FileWriter fw = new FileWriter(fl);
					for (String s:content)
					{
						fw.write(s+"\n");
					}
					fw.close();
					return true;
				}
				
			
			catch (Exception Ex)
				{
				return false;
				}
}
			

		/**
		 * This method will delete the file name if it exists
		 * @param folderpath
		 * @param fileName
		 * @return
		 */
			
public static boolean deleteFile(String folderpath, String fileName)
{
File file = new File(folderpath+"/"+fileName);

try
{
	if(file.delete())
		return true;
	else
		return false;
}
catch (Exception ex)
{
	return false;
}	
}
public static boolean searchFile(String folderpath, String fileName)
{
File file = new File(folderpath+"/"+fileName);

try
{
	if(file.exists())
		return true;
	else
		return false;
}
catch (Exception ex)
{
	return false;
}	
}
}
