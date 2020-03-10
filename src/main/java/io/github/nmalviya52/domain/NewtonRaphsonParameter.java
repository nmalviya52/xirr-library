package io.github.nmalviya52.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import io.github.nmalviya52.service.Constants;

@Getter @Setter @Builder
public class NewtonRaphsonParameter {
    @Builder.Default
    Integer iterations=Constants.NR_ITERATIONS;
    @Builder.Default
    Double error=Constants.NR_ERROR;
    @Builder.Default
    Double guess=Constants.XIRR_INITIAL_GUESS;
}
