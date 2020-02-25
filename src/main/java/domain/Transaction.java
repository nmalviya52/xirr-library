package domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Transaction implements Comparable<Transaction> {
    Date date;
    Double value;

    public Transaction(@NonNull Date date,@NonNull Double value){
        this.date=date;
        this.value=value;
    }

    @Override
    public int compareTo(Transaction o) {
        return this.getDate().compareTo(o.getDate());
    }
}
