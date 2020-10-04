package fileBusinessLogic;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class BusinessLogic {

	public boolean checkFile(String fileName) throws IOException {
		File myFile= new File("D:\\Programing\\FileManagement\\Root\\"+fileName+".txt");
		if(myFile.exists()) {
			
			return true;
		}else{
			return false;
		}
	}


	public boolean checkFileSensi(String fileName) throws IOException {
		File myFile= new File("D:\\Programing\\FileManagement\\Root\\"+fileName+".txt");
		if(myFile.exists() && myFile.getCanonicalFile().getName().equals(myFile.getName())) {
			
			return true;
		}else{
			return false;
		}
	}


	public void showFiles() {

		File showFile = new File("D:\\Programing\\FileManagement\\Root\\");
		String fileList[]= showFile.list();
		Arrays.sort(fileList);
		Arrays.toString(fileList);
		System.out.println("\nList of Files as per your request:-");
		for (int i = 0; i < fileList.length; i++) {
			System.out.println((i+1)+"."+fileList[i]);
		}
	}

public void AddFile(Scanner sc) throws IOException {
		
		String str;
		boolean status;
		do{
			System.out.println("\nPlease type Name of the File");
			str= sc.nextLine();
			status=!checkFile(str);
			if (!status) {
				System.out.println("File is already there.");
			}

		}
		while(!status);
		FileWriter fw;
		BufferedWriter bw;
		str="D:\\Programing\\FileManagement\\Root\\"+str+".txt";
		try {
			fw = new FileWriter(str);
			bw=new BufferedWriter(fw);
			System.out.println("Enter file content (Enter 'done' for to save):");

			while(true){ 
				String input = sc.nextLine(); 
				if("DONE".equalsIgnoreCase(input.trim()))
				{ 

					break; 
				} 
				bw.write(input); 
				bw.newLine();
			}
			bw.close();
			fw.close();
			System.out.println("File Added Successfully.");
		} catch (IOException e1)
		{
			System.out.println(e1.getMessage());
		}
		sc.reset();
	}


	public void searchFile(Scanner sc) throws IOException {
		//Scanner sc = new Scanner(System.in);
		String str= sc.nextLine();
		if(checkFileSensi(str)) {
			System.out.println("File Found Sucessfully.");
			File myFile1= new File(str);
			if(myFile1.exists()) 
				System.out.println("The File: "+myFile1.getName()+" is "+myFile1.length()+" byte long");
			System.out.println("path:"+myFile1.getAbsolutePath());
			
		}

		else {
			System.out.println("File not found.");
		}

		sc.reset();

	}

	public void deleteFile(Scanner sc) throws IOException {

		System.out.println("Type name which file you want to delete");
		String str = sc.nextLine();

		File myFile = new File("D:\\Programing\\FileManagement\\Root\\"+str+".txt");

		if(checkFileSensi(str)) {
			myFile.delete();
			
			System.out.println(myFile.getName()+" is deleted succesfully.");
		}
		else
		{
			System.out.println(("No such file found, please type exact name."));
		}
		sc.reset();
	}
	
}




