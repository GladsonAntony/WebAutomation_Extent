package tests;

import org.testng.annotations.Test;
import utils.DateAndTime;
import utils.RandomGenerator;

public class TestProperties {
    @Test
    public void testPropertiesFile() throws Exception {
        System.out.println(DateAndTime.getDate());
        System.out.println(DateAndTime.getTime());
        System.out.println(DateAndTime.getMonth_Full());
        System.out.println(DateAndTime.getDayOfTheMonth());
        System.out.println(DateAndTime.getDayCount());
        System.out.println(DateAndTime.getYear());
        System.out.println(DateAndTime.getHourOfTheDay());
        System.out.println(DateAndTime.getWeekCount());
        System.out.println(RandomGenerator.GenerateRandomEMAILIDs());
        System.out.println(RandomGenerator.GenerateRandomEMAILIDs("pokemon.co"));
    }
}
