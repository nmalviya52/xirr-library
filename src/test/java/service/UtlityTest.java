package service;

import domain.Transaction;
import org.junit.Test;
import service.Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class UtlityTest{
    @Test
    public void testDifferenceInYears() throws ParseException {
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2010");
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2011");
        Double result = Utility.findDifferenceInYears(date1,date2);
        assertEquals(1.0d, result,0.000000001d);
    }

    @Test
    public void testDifferenceInDays() throws ParseException {
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2010");
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2011");
        Double result = Utility.findDifferenceInDays(date1,date2);
        assertEquals(365.0d, result,0.000000001d);
    }
}
