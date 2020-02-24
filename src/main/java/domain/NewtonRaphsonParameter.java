package domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class NewtonRaphsonParameter {
    Integer iterations;
    Double error;
    Double guess;
}
