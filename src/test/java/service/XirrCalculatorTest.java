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

public class XirrCalculatorTest {
    @Test
    public void testCalculateXirrMethod() throws ParseException {
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(this.getTransactionFrom("01/01/2010",100.0d));
        transactionList.add(this.getTransactionFrom("01/01/2011", -200.0d));
        XirrCalculator xirrCalculator = new XirrCalculator();
        Double result = xirrCalculator.calculate(transactionList,NewtonRaphsonParameter.builder());
        assertEquals(1.0d, result,Constants.NR_ERROR);
    }

    @Test
    public void testCalculateXirrMethod2() throws ParseException{
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(this.getTransactionFrom("01/01/1993",	5000.0d));
        transactionList.add(this.getTransactionFrom("01/01/1996",	5000.0d));
        transactionList.add(this.getTransactionFrom("01/01/1997",	5000.0d));
        transactionList.add(this.getTransactionFrom("01/01/1998",	10000.0d));
        transactionList.add(this.getTransactionFrom("01/01/1998",-30000.0d));
        transactionList.add(this.getTransactionFrom("01/01/1999",	10000.0d));
        transactionList.add(this.getTransactionFrom("01/01/2000",	10000.0d));
        transactionList.add(this.getTransactionFrom("01/01/2001",	10000.0d));
        transactionList.add(this.getTransactionFrom("01/01/2002",	10000.0d));
        transactionList.add(this.getTransactionFrom("01/01/2003",	10000.0d));
        transactionList.add(this.getTransactionFrom("01/01/2004",	10000.0d));
        transactionList.add(this.getTransactionFrom("01/01/2005",-100000.0d));
        XirrCalculator xirrCalculator = new XirrCalculator();
        Double result = xirrCalculator.calculate(transactionList,NewtonRaphsonParameter.builder());
        assertEquals(0.1361d,result,0.01d);
    }

    private Transaction getTransactionFrom(String dateString, Double value) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        Transaction transaction = new Transaction(date, value);
        return  transaction;
    }
}
