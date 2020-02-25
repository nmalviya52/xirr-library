package service;

import domain.NewtonRaphsonParameter;
import domain.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class XirrCalculator {

    /**
     * Usage:
     * XirrCalculator xirrCalculator = new XirrCalculator();
     * Double result = xirrCalculator.calculate(transactionList,
     *                                          NewtonRaphsonParameter
     *                                          .builder()
     *                                          .guess(0.15)
     *                                          .iteration(1000)
     *                                          .error(0.0001d));
     *
     * @param transactionList
     * @param newtonRaphsonParameterBuilder with the required parameter
     * @return XIRR for all the transactions
     */
    public Double calculate(List<Transaction> transactionList, NewtonRaphsonParameter.NewtonRaphsonParameterBuilder newtonRaphsonParameterBuilder) {
        List<Transaction> modifiedTransactionList = new ArrayList<>(transactionList);
        Collections.sort(modifiedTransactionList);
        return new NewtonRaphson(new FunctionCalculator(modifiedTransactionList), new FunctionDerivativeCalculator(modifiedTransactionList), newtonRaphsonParameterBuilder.build()).findResult();
    }

    /**
     * @param transactionList               - List of all transaction made so far
     * @param value                         - Current value of the investment
     * @param valueDate                     - Date on which the current value is realized
     * @param newtonRaphsonParameterBuilder - Parameter used for newton raphson method to get XIRR
     * @return XIRR for all the transaction
     */
    public Double calculate(List<Transaction> transactionList, Double value, Date valueDate, NewtonRaphsonParameter.NewtonRaphsonParameterBuilder newtonRaphsonParameterBuilder) {
        List<Transaction> modifiedTransactionList = new ArrayList<>(transactionList);
        Transaction lastTransaction = new Transaction(valueDate, -1.0 * value);
        modifiedTransactionList.add(lastTransaction);
        Collections.sort(modifiedTransactionList);
        return new NewtonRaphson(new FunctionCalculator(modifiedTransactionList), new FunctionDerivativeCalculator(modifiedTransactionList), newtonRaphsonParameterBuilder.build()).findResult();
    }
}
