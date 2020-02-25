package service;

import domain.NewtonRaphsonParameter;
import domain.Transaction;

import java.util.*;

public class XirrCalculator {

    public Double calculate(List<Transaction> transactionList, NewtonRaphsonParameter.NewtonRaphsonParameterBuilder newtonRaphsonParameterBuilder) {
        List<Transaction> modifiedTransactionList = new ArrayList<>(transactionList);
        Collections.sort(modifiedTransactionList);
        return new NewtonRaphson(new FunctionCalculator(modifiedTransactionList), new FunctionDerivativeCalculator(modifiedTransactionList), newtonRaphsonParameterBuilder.build()).findResult();
    }

    public Double calculate(List<Transaction> transactionList, Double value, Date valueDate, NewtonRaphsonParameter.NewtonRaphsonParameterBuilder newtonRaphsonParameterBuilder) {
        List<Transaction> modifiedTransactionList = new ArrayList<>(transactionList);
        Transaction lastTransaction = new Transaction(valueDate, -1.0 * value);
        modifiedTransactionList.add(lastTransaction);
        Collections.sort(modifiedTransactionList);
        return new NewtonRaphson(new FunctionCalculator(modifiedTransactionList), new FunctionDerivativeCalculator(modifiedTransactionList), newtonRaphsonParameterBuilder.build()).findResult();
    }
}
