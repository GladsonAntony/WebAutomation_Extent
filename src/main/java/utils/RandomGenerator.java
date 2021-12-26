package utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * @Author Gladson Antony
 * @Date 25-Dec-2016
 */

public class RandomGenerator {

    public static Random rand = new Random();
    public static Faker faker = new Faker();

    /*	To Generate Random Numbers of the Entered Length.*/
    public static String GenerateRandomNumber(int length) {
        StringBuffer output = new StringBuffer(1000);
        output.append("1");
        for (int i = 1; i < length; i++) {
            output.append(0);
        }
        int num = Integer.parseInt(output.toString());
        int maxnum = (num * 10) - 1;
        int randnum = num + rand.nextInt(maxnum) + 1;

        return Integer.toString(randnum);
    }

    /*	To Generate Random Capitalized Letters of the Entered Length.*/
    public static String GenerateRandomCapitalizedString(int length) {
        StringBuffer output = new StringBuffer(1000);
        output.append((char) (rand.nextInt(26) + 'A'));
        System.out.println(output.toString());

        for (int i = 1; i < 10; i++) {
            char c = (char) (rand.nextInt(26) + 'a');
            output.append(c);
        }
        return output.toString();
    }

    /*	To Generate Random Small Letters of the Entered Length.*/
    public static String GenerateRandomSmallLetters(int length) {
        StringBuffer output = new StringBuffer(1000);
        output.append((char) (rand.nextInt(26) + 'a'));
        System.out.println(output.toString());

        for (int i = 1; i < 10; i++) {
            char c = (char) (rand.nextInt(26) + 'a');
            output.append(c);
        }
        return output.toString();
    }


    /*	To Generate Random Capital Letters of the Entered Length.*/
    public static String GenerateRandomCapitalLetters(int length) {
        StringBuffer output = new StringBuffer(1000);
        output.append((char) (rand.nextInt(26) + 'A'));
        System.out.println(output.toString());

        for (int i = 1; i < 10; i++) {
            char c = (char) (rand.nextInt(26) + 'A');
            output.append(c);
        }
        return output.toString();
    }

    /*	To Generate Random Alpha-Numeric Characters of the Entered Length.*/
    public static String GenerateRandomAlphaNumericCharacters(int length) {
        return RandomStringUtils.randomAlphanumeric(length).toString();
    }

    /*	To Generate Random ASCII Characters of the Entered Length.*/
    public static String GenerateRandomASCIICharacters(int length) {
        return RandomStringUtils.randomAscii(length).toString();
    }

    /*	To Generate Random E-Mail IDs(Auto Generate Domain Names.*/
    public static String GenerateRandomEMAILIDs() {
        String EmailID = faker.name().fullName().toString().replaceAll(" ","");
        String Domain = faker.company().name().toString().replaceAll(" ","");
        return EmailID + "@" + Domain + ".com";
    }

    /*	To Generate Random E-Mail IDs.*/
    public static String GenerateRandomEMAILIDs(String DomainName) {
        String EmailID = faker.name().fullName().replaceAll(" ","");
        return EmailID + "@" + DomainName;
    }
}