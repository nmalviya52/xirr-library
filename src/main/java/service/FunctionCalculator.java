package service;

import domain.Transaction;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class FunctionCalculator implements Function<Double,Double> {
    List<Transaction> transactions;

    public FunctionCalculator(List<Transaction> transactionList){
        this.transactions = transactionList;
    }

    @Override
    public Double apply(Double result) {
        Double value = 0.0;
        Date maxDate = Utility.getMaxDateInTransaction(transactions);
        for(Transaction transaction : transactions){
            Date date = transaction.getDate();
            value = value + (transaction.getValue()*Math.pow(1.0 + result,Utility.findDifferenceInYears(date,maxDate)));
        }
        return value;
    }
}
