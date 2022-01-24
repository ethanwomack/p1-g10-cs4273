import java.io.*;
import java.util.Scanner;

public class main {

	static char[] spanish;
	static char[] english;
	final static String englishFileName = "english.csv";
	final static String spanishFileName = "spanish.csv";
	static Scanner englishScnr;
	static Scanner spanishScnr;
	
	
	public static void main(String[] args)
	{
		try
		{
			File englishFile = new File(englishFileName);
			File spanishFile = new File(spanishFileName);
			Scanner englishScnr = new Scanner(englishFile);
			Scanner spanishScnr = new Scanner(spanishFile);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found :^(");
		}
		englishScnr.useDelimiter(",");
		english = englishScnr.nextLine().toCharArray();
		
		spanishScnr.useDelimiter(",");
		spanish = spanishScnr.nextLine().toCharArray();
		
		englishScnr.close();
		spanishScnr.close();
		
		//Input Loop
		Scanner scnr = new Scanner(System.in);
		String input = scnr.nextLine();
		boolean isEnglish = false;
		boolean isSpanish = false;
		
		while(!input.equals("QUIT"))
		{
			System.out.println("Enter the character and I will tell you what language you are using   \n (Only Supports English and Spanish)");
			System.out.println("Type QUIT to exit");
			
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
			
			input = scnr.nextLine();
		}
		scnr.close();
	}
	
}
