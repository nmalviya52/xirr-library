package io.github.nmalviya52.service;

import io.github.nmalviya52.domain.Transaction;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FunctionCalculatorTest {
    @Test
    public void testFunctionCalculator() throws ParseException {
        List<Transaction> transactionList = new ArrayList<>();
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2010");
        Transaction transaction1 = new Transaction(date1, 100.0d);
        transactionList.add(transaction1);
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2011");
        Transaction transaction2 = new Transaction(date2, -200.0d);
        transactionList.add(transaction2);
        FunctionCalculator functionCalculator = new FunctionCalculator(transactionList);
        Double result = functionCalculator.apply(1.0d);
        assertEquals(0.0d, result, Constants.NR_ERROR);
    }

    @Test
    public void testFunctionDerivativeCalculator() throws ParseException {
        List<Transaction> transactionList = new ArrayList<>();
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2010");
        Transaction transaction1 = new Transaction(date1, 100.0d);
        transactionList.add(transaction1);
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2011");
        Transaction transaction2 = new Transaction(date2, -200.0d);
        transactionList.add(transaction2);
        Collections.sort(transactionList);
        FunctionDerivativeCalculator functionDerivativeCalculator = new FunctionDerivativeCalculator(transactionList);
        Double result = functionDerivativeCalculator.apply(1.0d);
        assertEquals(100.0d, result, 0.000001);
    }
}
