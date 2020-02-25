package service;

import domain.NewtonRaphsonParameter;
import domain.Transaction;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NewtonRaphsonTest {
    @Test
    public void testNewtonRaphsonMethod() throws ParseException {
        List<Transaction> transactionList = new ArrayList<>();
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2010");
        Transaction transaction1 = new Transaction(date1, 100.0d);
        transactionList.add(transaction1);
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2011");
        Transaction transaction2 = new Transaction(date2, -200.0d);
        transactionList.add(transaction2);
        NewtonRaphsonParameter newtonRaphsonParameter = NewtonRaphsonParameter.builder().error(0.000001).guess(10.0).iterations(1000).build();
        Double result = new NewtonRaphson(new FunctionCalculator(transactionList),new FunctionDerivativeCalculator(transactionList),newtonRaphsonParameter).findResult();
        assertEquals(1.0d,result,Constants.NR_ERROR);
    }
}
