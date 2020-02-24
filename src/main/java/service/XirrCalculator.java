package service;

import domain.NewtonRaphsonParameter;
import domain.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XirrCalculator {

    public Double calculate(List<Transaction> transactionList, NewtonRaphsonParameter.NewtonRaphsonParameterBuilder newtonRaphsonParameterBuilder) {
        return new NewtonRaphson(new FunctionCalculator(transactionList), new FunctionDerivativeCalculator(transactionList), newtonRaphsonParameterBuilder.build()).findResult();
    }

    public Double calculate(List<Transaction> transactionList, Double value, Date valueDate, NewtonRaphsonParameter.NewtonRaphsonParameterBuilder newtonRaphsonParameterBuilder) {
        List<Transaction> modifiedTransactionList = new ArrayList<>(transactionList);
        Transaction lastTransaction = new Transaction(valueDate, -1.0 * value);
        modifiedTransactionList.add(lastTransaction);
        return new NewtonRaphson(new FunctionCalculator(modifiedTransactionList), new FunctionDerivativeCalculator(modifiedTransactionList), newtonRaphsonParameterBuilder.build()).findResult();
    }
}
