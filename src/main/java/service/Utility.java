package service;

import domain.Transaction;

import javax.naming.CompositeName;
import java.util.Date;
import java.util.List;

public class Utility {
    public static Date getMaxDateInTransaction(List<Transaction> transactionList) {
        return transactionList.stream().map(transaction -> transaction.getDate()).max(Date::compareTo).get();
    }

    public static Date getMinDateInTransaction(List<Transaction> transactionList) {
        return transactionList.stream().map(transaction -> transaction.getDate()).min(Date::compareTo).get();
    }

    public static Double findDifferenceInDays(Date date1, Date date2){
        return ((date2.getTime()-date1.getTime())*1.0d)/(1.0d*Constants.DAYS_IN_MILLISECONDS);
    }

    public static Double findDifferenceInYears(Date date1, Date date2){
        return ((date2.getTime()-date1.getTime())*1.0d)/(1.0d*Constants.YEARS_IN_MILLISECONDS);
    }
}
