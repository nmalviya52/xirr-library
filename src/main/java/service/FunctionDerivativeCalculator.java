package service;

import domain.Transaction;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class FunctionDerivativeCalculator implements Function<Double,Double> {
    List<Transaction> transactions;

    public FunctionDerivativeCalculator(List<Transaction> transactionList){
        this.transactions = transactionList;
    }

    @Override
    public Double apply(Double result) {
        Double value = 0.0;
        Date maxDate = Utility.getMaxDateInTransaction(transactions);
        for(Transaction transaction : transactions){
            Date date = transaction.getDate();
            Double period = Utility.findDifferenceInYears(date,maxDate);
            value = value + period*(transaction.getValue()*Math.pow(1.0 + result,period-1.0));
        }
        return value;
    }

}
