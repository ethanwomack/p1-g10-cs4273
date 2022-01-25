import java.io.*;
import java.util.Scanner;

public class main {
	final static String englishFileName = "english.csv";
	final static String spanishFileName = "spanish.csv";	
	
	public static void main(String[] args)
	{
		char[] spanish = new char[54];
		char[] english = new char[52];
		try
		{
		File englishFile = new File(englishFileName);
		File spanishFile = new File(spanishFileName);
		Scanner englishScnr = new Scanner(englishFile);
		Scanner spanishScnr = new Scanner(spanishFile);
		
		english = englishScnr.nextLine().replaceAll(",", "").toCharArray();

		spanish = spanishScnr.nextLine().replaceAll(",","").toCharArray();
		
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
		boolean isEnglish = false;
		boolean isSpanish = false;	
		while(!input.equals("QUIT"))
		{	
			isEnglish = false;
			isSpanish = false;
			
			for(int i = 0; i < english.length; i++)
			{
				if(input.charAt(0) == english[i])
				{
					isEnglish = true;
				}
			}
			
			for(int i = 0; i < spanish.length; i++)
			{
				if(input.charAt(0) == spanish[i])
				{
					isSpanish = true;
				}
			}
			if(isEnglish)		
			{
				if(isSpanish)
				{
					System.out.println("The character is both English and Spanish");
				}
				else
				{
					System.out.println("The character is English");
				}
			}
			
			else if(isSpanish)
			{
				System.out.println("The character is Spanish");
			}
			else
			{
				System.out.println("The character is neither English or Spanish");
			}
			
			System.out.println("Enter the character and I will tell you what language you are using   \n (Only Supports English and Spanish)");
			System.out.println("Type QUIT to exit");
			input = scnr.nextLine();
		}
		scnr.close();
	}
	
}