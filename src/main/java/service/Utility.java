package service;

import java.util.Date;

public class Utility {
    /**
     *
     * @param date1
     * @param date2
     * @return Find difference between 2 dates in days
     */
    public static Double findDifferenceInDays(Date date1, Date date2) {
        return (Math.abs(date2.getTime() - date1.getTime()) * 1.0d) / (1.0d * Constants.DAYS_IN_MILLISECONDS);
    }

    /**
     *
      * @param date1
     * @param date2
     * @return Find difference between 2 dates in years
     */
    public static Double findDifferenceInYears(Date date1, Date date2) {
        return (Math.abs(date2.getTime() - date1.getTime()) * 1.0d) / (1.0d * Constants.YEARS_IN_MILLISECONDS);
    }
}
