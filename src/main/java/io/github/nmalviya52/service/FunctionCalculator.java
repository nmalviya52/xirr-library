package io.github.nmalviya52.service;

import io.github.nmalviya52.domain.Transaction;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class FunctionCalculator implements Function<Double, Double> {
    List<Transaction> transactions;

    public FunctionCalculator(List<Transaction> transactionList) {
        this.transactions = transactionList;
    }

    @Override
    public Double apply(Double result) {
        Double value = 0.0;
        // last index is max date as it is sorted
        Date maxDate = transactions.get(transactions.size() - 1).getDate();
        for (Transaction transaction : transactions) {
            Date date = transaction.getDate();
            value = value + (transaction.getValue() * Math.pow(1.0 + result, Utility.findDifferenceInYears(date, maxDate)));
        }
        return value;
    }
}
