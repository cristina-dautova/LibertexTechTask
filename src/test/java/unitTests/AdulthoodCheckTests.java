package unitTests;

import function.AdulthoodCheck;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AdulthoodCheckTests {

    @Test
    public void moreThanEighteen() throws ParseException {
        Calendar calendar = new GregorianCalendar();
        calendar.roll(Calendar.YEAR, -20);
        Assert.assertTrue(AdulthoodCheck.verifyIfUserHasEighteen(calendar.getTime()));
    }

    @Test
    public void lessThanEighteen() throws ParseException {
        Calendar calendar = new GregorianCalendar();
        calendar.roll(Calendar.YEAR, -15);
        Assert.assertFalse(AdulthoodCheck.verifyIfUserHasEighteen(calendar.getTime()));
    }

    @Test
    public void lessThanEighteenAndBirthDateIsCurrentDate() {
        Date date = new Date();
        Assert.assertFalse(AdulthoodCheck.verifyIfUserHasEighteen(date));
    }

    @Test
    public void exactlyEighteen() {
        Calendar calendar = new GregorianCalendar();
        calendar.roll(Calendar.YEAR, -18);
        Assert.assertTrue(AdulthoodCheck.verifyIfUserHasEighteen(calendar.getTime()));
    }

    @Test
    public void eighteenMinusOneMinute() {
        Calendar calendar = new GregorianCalendar();
        calendar.roll(Calendar.YEAR, -18);
        calendar.roll(Calendar.MINUTE, -1);
        Assert.assertTrue(AdulthoodCheck.verifyIfUserHasEighteen(calendar.getTime()));
    }

    @Test
    public void eighteenPlusOneMinute() {
        Calendar calendar = new GregorianCalendar();
        calendar.roll(Calendar.YEAR, -18);
        calendar.roll(Calendar.MINUTE, 1);
        Assert.assertTrue(AdulthoodCheck.verifyIfUserHasEighteen(calendar.getTime()));
    }

    @Test(expectedExceptions = {NullPointerException.class})
    public void nullPointerException() {
        Assert.assertFalse(AdulthoodCheck.verifyIfUserHasEighteen(null));
    }
}
