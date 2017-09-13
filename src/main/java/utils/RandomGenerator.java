package utils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @Author Gladson Antony
 * @Date 25-Dec-2016
 */

public class RandomGenerator 
{

	public static Random rand = new Random();

	/*	To Generate Random Numbers of the Entered Length.*/
	public static String GenerateRandomNumber(int length)
	{
		StringBuffer output = new StringBuffer(1000);
		output.append("1");
		for (int i = 1; i < length; i++)
		{
			output.append(0);
		}
		int num = Integer.parseInt(output.toString());
		int maxnum = (num*10) - 1;
		int randnum = num + rand.nextInt(maxnum) + 1;

		String RandNum = new Integer(randnum).toString();
		return RandNum;
	}

	/*	To Generate Random Capitalized Letters of the Entered Length.*/
	public static String GenerateRandomCapitalizedString(int length)
	{
		StringBuffer output = new StringBuffer(1000);
		output.append((char)(rand.nextInt(26) + 'A'));
		System.out.println(output.toString());

		for(int i = 1; i < 10; i++)
		{
			char c = (char)(rand.nextInt(26) + 'a');
			output.append(c);
		}
		String RandCapitalizedString = output.toString();
		return RandCapitalizedString;
	}

	/*	To Generate Random Small Letters of the Entered Length.*/
	public static String GenerateRandomSmallLetters(int length)
	{
		StringBuffer output = new StringBuffer(1000);
		output.append((char)(rand.nextInt(26) + 'a'));
		System.out.println(output.toString());

		for(int i = 1; i < 10; i++)
		{
			char c = (char)(rand.nextInt(26) + 'a');
			output.append(c);
		}
		String RandSmallLetters = output.toString();
		return RandSmallLetters;
	}


	/*	To Generate Random Capital Letters of the Entered Length.*/
	public static String GenerateRandomCapitalLetters(int length)
	{
		StringBuffer output = new StringBuffer(1000);
		output.append((char)(rand.nextInt(26) + 'A'));
		System.out.println(output.toString());

		for(int i = 1; i < 10; i++)
		{
			char c = (char)(rand.nextInt(26) + 'A');
			output.append(c);
		}
		String RandCapitalLetters = output.toString();

		return RandCapitalLetters;
	}

	/*	To Generate Random Alpha-Numeric Characters of the Entered Length.*/
	public static String GenerateRandomAlphaNumericCharacters(int length)
	{
		return RandomStringUtils.randomAlphanumeric(length).toString();
	}

	/*	To Generate Random ASCII Characters of the Entered Length.*/
	public static String GenerateRandomASCIICharacters(int length)
	{
		return RandomStringUtils.randomAscii(length).toString();
	}

	/*	To Generate Random E-Mail IDs(Auto Generate Domain Names.*/
	public static String GenerateRandomEMAILIDs()
	{
		String EmailID = RandomStringUtils.randomAlphabetic(15).toString();
		String Domain = RandomStringUtils.randomAlphabetic(7).toLowerCase().toString();

		return EmailID + "@" + Domain + ".com";
	}

	/*	To Generate Random E-Mail IDs.*/
	public static String GenerateRandomEMAILIDs(String DomainName)
	{
		String EmailID = RandomStringUtils.randomAlphabetic(15).toString();

		return EmailID + "@" + DomainName ;
	}
}
