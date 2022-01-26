import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.*;

public class MainTest 
{
	// testing checkChar tests the other two methods within main as well
	//====================
	// a
	@Test
	public void givenBothReturn3() 
	{
		char[] spanish = new char[54];
		char[] english = new char[52];
		try
		{
		File englishFile = new File("english.csv");
		File spanishFile = new File("spanish.csv");
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
		
		char test = 'a';
	    int actual = main.checkChar(test, english, spanish);
	    int expected = 3;
	    Assert.assertEquals(expected, actual); 
	}
	
	// spanish n with tilde
	@Test
	public void givenBothReturn2() 
	{
		char[] spanish = new char[54];
		char[] english = new char[52];
		try
		{
		File englishFile = new File("english.csv");
		File spanishFile = new File("spanish.csv");
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
		
		char test = 'ñ';
	    int actual = main.checkChar(test, english, spanish);
	    int expected = 2;
	    Assert.assertEquals(expected, actual); 
	}
	
	// no character that appears in english doesnt appear in spanish... function should never return 1
	
	// numbers are not considered to be in part of either language
	@Test
	public void givenBothReturn0() 
	{
		char[] spanish = new char[54];
		char[] english = new char[52];
		try
		{
		File englishFile = new File("english.csv");
		File spanishFile = new File("spanish.csv");
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
		
		char test = '0';
	    int actual = main.checkChar(test, english, spanish);
	    int expected = 0;
	    Assert.assertEquals(expected, actual); 
	}
	
}
