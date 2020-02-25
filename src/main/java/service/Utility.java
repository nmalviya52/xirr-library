package service;

import domain.Transaction;

import javax.naming.CompositeName;
import java.util.Date;
import java.util.List;

public class Utility {
    public static Double findDifferenceInDays(Date date1, Date date2){
        return ((date2.getTime()-date1.getTime())*1.0d)/(1.0d*Constants.DAYS_IN_MILLISECONDS);
    }

    public static Double findDifferenceInYears(Date date1, Date date2){
        return ((date2.getTime()-date1.getTime())*1.0d)/(1.0d*Constants.YEARS_IN_MILLISECONDS);
    }
}
