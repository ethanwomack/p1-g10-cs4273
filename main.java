import java.io.*;
import java.util.Scanner;

public class main {
	final static String englishFileName = "english.csv";
	final static String spanishFileName = "spanish.csv";	
	
	public static void main(String[] args)
	{
		// initialize char arrays up to the amount of characters present in each language
		char[] spanish = new char[54];
		char[] english = new char[52];
		
		// Test for reading in files with characters for both alphabets
		try
		{
			File englishFile = new File(englishFileName);
			File spanishFile = new File(spanishFileName);
			Scanner englishScnr = new Scanner(englishFile);
			Scanner spanishScnr = new Scanner(spanishFile);
		
			english = englishScnr.nextLine().replaceAll(",", "").toCharArray();
			spanish = spanishScnr.nextLine().replaceAll(",", "").toCharArray();
		
			englishScnr.close();
			spanishScnr.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found :^(");
		}
		
		//Input Loop
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter the character and I will tell you what language you are using   \n (Only Supports English and Spanish)");
		System.out.println("Type QUIT to exit");
		String input = scnr.nextLine();
			
		while(!input.equals("QUIT"))
		{	
			// check if character is in english or spanish, neither or both languages
			int val = checkChar(input.charAt(0), english, spanish);
			
			// print out what language the character is in
			switch (val)
			{
				case 0: // Neither Language
					System.out.println("The character is neither English or Spanish");
					break;
				case 1: // Only English, Should not execute ever
					System.out.println("The character is English");
					break;
				case 2: // Only Spanish
					System.out.println("The character is Spanish");
					break;
				case 3: // Both Spanish and English
					System.out.println("The character is both English and Spanish");
					break;
			}
			
			// priming read
			System.out.println("Enter the character and I will tell you what language you are using   \n (Only Supports English and Spanish)");
			System.out.println("Type QUIT to exit");
			input = scnr.nextLine();
		}
		
		scnr.close();
	}
	
	/*
	 * Checks If the character is in english, spanish, neither, or both languages
	 * Returns 0 if character is in neither language,
	 * 1 if character is only in english (this should never be returned)
	 * 2 if character is only in spanish
	 * 3 if character is in both languages
	 */
	public static int checkChar(char input, char[] english, char[] spanish)
	{
		boolean isEnglish = checkEnglish(input, english);
		boolean isSpanish = checkSpanish(input, spanish);
					
		if(isEnglish)
			if(isSpanish) // Both 
				return 3;
			else // only english
				return 1;
		else if(isSpanish) // only spanish
			return 2;
		else // neither
			return 0;		
	}

	/*
	 * Check if character is in the spanish alphabet
	 * Returns True or False
	 */
	private static boolean checkSpanish(char input, char[] spanish) 
	{
		for(int i = 0; i < spanish.length; i++)
			if(input == spanish[i])
				return true;
		
		// not in alphabet
		return false;
	}

	/*
	 * Check if character is in the english alphabet
	 * Returns True or False
	 */
	private static boolean checkEnglish(char input, char[] english) 
	{
		for(int i = 0; i < english.length; i++)
			if(input == english[i])
				return true;
		
		// not in alphabet
		return false;
	}
}
