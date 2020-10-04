package fileBusinessLogic;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opt1 = 0;
		int opt2 = 0;


		BusinessLogic bl = new BusinessLogic();

		System.out.println("\t\t\t\t\t\t\tFILE MANAGEMENT SYSTEM");
		System.out.println("\t\t\t\t\t\t\t    Devloped By");
		System.out.println("\t\t\t\t\t\t\t   Rupesh Rahate");		


		do {
			System.out.println("*********************************************************************************************************************");
			System.out.println("\n\n\nServices we offered to you");
			System.out.println("\n[1]. Show all files in System");
			System.out.println("[2]. Operations with Files");
			System.out.println("[3]. Exit");
			System.out.println("\n\n\nPlease Enter your choice from above options:-");
			try {
				opt1=Integer.parseInt(sc.nextLine());
			} catch (Exception e) {

			}

			switch (opt1) {
			case 1: 
				bl.showFiles();
				break;
			case 2:
				do {


					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("\nWhich Operation you want to perform?");
					System.out.println("1) Add File to System");
					System.out.println("2) Delete File from the System");
					System.out.println("3) Search File in the System");
					System.out.println("4) Go Back to Service Menu");
					System.out.println("--------------------------------------------------------------------------------------------------------------");
					System.out.println("\n\n\nPlease Enter your choice from above options:-");
					try {
						opt2=Integer.parseInt(sc.nextLine());

						switch (opt2) {

						case 1: 
							try {
								bl.AddFile(sc);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								System.out.println(e.getMessage());
							}
							sc.reset();

							break;

						case 2: 
							try {
								bl.deleteFile(sc);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								System.out.println(e.getMessage());
							}
							sc.reset();

							break;

						case 3: 
							System.out.println("\nPlease enter the text-file name for search");
							try {
								bl.searchFile(sc);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								System.out.println(e.getMessage());
							}
							sc.reset();
							break;
						case 4: 
							System.out.println("Go to Main Menu.");
							sc.reset();
							break;

						default: System.out.println("Inavlid Input-Please give input from(1-4).");
						break;


						}
					}
					catch (Exception e) {
						System.out.println("Inavlid Input-Please give input from(1-4).");
					}
				}

				while(opt2!=4);

				break;

			case 3:
				System.out.println("\n\n\n\t\t\t\t\t\t       Thank You for choosing us!");
				System.out.println("\t\t\t\t\t\t             See You Again!!!");
				sc.close();
				break;

			default:
				System.out.println("Invalid input-Please enter option from [1-3].");

				break;
			}

		} while (opt1!=3);

	}


}
