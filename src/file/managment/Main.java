package file.managment;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	static MainPoint application = new MainPoint();

	public static void main(String[] args) {

		printApplicationAndDeveloperDetails();
		printOptions();
		String pathname = ".";
		try (Scanner cin = new Scanner(System.in);) {
			while (true) {
				int nextInt = 0;
				try {
					nextInt = cin.nextInt();
				} catch (Exception e) {
					System.out.println("Invalid Input");

				}
				switch (nextInt) {
				case 0:
					System.out.println("You Are In This PAth ".concat(pathname));

					navigateTo(pathname);
					System.out.println("-----------------------------");
					break;
				case 1:
					printUserActions();
					System.out.println("-----------------------------");
					break;
				case 2:
					System.out.println("Enter Dir Name");
					String nextPath = cin.next();
					String pathnameNew = getNextPath(pathname, "/".concat(nextPath));
					if (application.isExist(pathnameNew)) {
						pathname = pathnameNew;
					} else {
						System.out.println("Dir Not Found");
					}
					System.out.println("You Are In This PAth ".concat(pathname));

					System.out.println("-----------------------------");
					break;
				case 3:
					pathname = back(pathname);
					System.out.println("You Are In This PAth ".concat(pathname));
					System.out.println("-----------------------------");

					break;
				case 4:
					System.out.println("Enter File Name");

					String file = cin.next();
					addFileInThisPAth(pathname, file);
					System.out.println("You Are In This PAth ".concat(pathname));
					System.out.println("-----------------------------");
					break;
				case 5:
					System.out.println("Enter File Name");

					file = cin.next();
					deleteFileInThisPAth(pathname, file);
					System.out.println("You Are In This PAth ".concat(pathname));
					System.out.println("-----------------------------");

					break;
				case 6:
					System.out.println("Enter File Name");

					file = cin.next();
					searchForAFile(file);
					System.out.println("You Are In This PAth ".concat(pathname));
					System.out.println("-----------------------------");

					break;
				case 7:
					System.out.println("Bye");
					System.exit(1);

					break;
				default:
					printOptions();
					break;
				}

			}
		}

	}

	private static void printApplicationAndDeveloperDetails() {
		System.out.println("Simple File Managment Application ");

		System.out.println("Hazem Musallam");

	}

	public static void printOptions() {
		System.out.println("enter 0 to List All File Names");

		System.out.println("enter 1 to List All User  Actions");

	}

	public static void printUserActions() {
		System.out.println("enter 0 to List All File Names ");

		System.out.println("enter 2 to Navigate Into Next Dir");
		System.out.println("enter 3 to Navigate Back");
		System.out.println("enter 4 to create  file");
		System.out.println("enter 5 to remove file Or Directory");
		System.out.println("enter 6 to search file ");
		System.out.println("enter 7 to exsit ");
	}

	private static void searchForAFile(String fileName) {
		if (application.contaionThisFile(fileName)) {
			System.out.println("File  Found");

		} else {
			System.out.println("File Not Found");
		}
	}

	private static void deleteFileInThisPAth(String pathname, String fileName) {
		System.out.println("Delete File");
		pathname = pathname.concat("/".concat(fileName));
		application.deleteFile(pathname, fileName);
	}

	private static void addFileInThisPAth(String pathname, String fileName) {
		File dir = new File(pathname);
		dir.mkdirs();
		File tmp = new File(dir, fileName);
		try {
			tmp.createNewFile();
		} catch (IOException e) {
			System.out.println("Please Correct Your Inputs");
		}
	}

	private static String back(String pathname) {
		System.out.println("Return Back");
		int lastIndexOf = pathname.lastIndexOf('/');
		if (lastIndexOf > 0) {
			pathname = pathname.substring(0, lastIndexOf);
		}
		return pathname;
	}

	private static String getNextPath(String pathname, String newPath) {

		String concat = pathname.concat(newPath);

		return concat;
	}

	private static void navigateTo(String curDir) {
		System.out.println("Navigate To -------->".concat(curDir));
		File dir = new File(curDir);
		application.listAllFilesAndDirectories(dir);

	}
}
