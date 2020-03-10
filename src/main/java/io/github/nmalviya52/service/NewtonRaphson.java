package io.github.nmalviya52.service;

import io.github.nmalviya52.domain.NewtonRaphsonParameter;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Function;

@Getter
@Setter
public class NewtonRaphson {
    NewtonRaphsonParameter newtonRaphsonParameter;
    Function function;
    Function derivativeFunction;

    public NewtonRaphson(Function function, Function derivativeFunction, NewtonRaphsonParameter newtonRaphsonParameter) {
        this.newtonRaphsonParameter = newtonRaphsonParameter;
        this.function = function;
        this.derivativeFunction = derivativeFunction;
    }

    /**
     * Iterative applies newton raphson to get final result with maximum iteration upto newtonRaphsonParameter.iteration or till
     * the error is less than newtonRaphsonParameter.error with the initial guess newtonRaphsonparameter.guess
     * @return
     */
    public double findResult() {
        Double result = newtonRaphsonParameter.getGuess();
        for (int i = 0; i < newtonRaphsonParameter.getIterations(); i++) {
            Double functionValue = (Double) function.apply(result);
            Double derivativeValue = (Double) derivativeFunction.apply(result);
            Double newResult = result - (functionValue * 1.0) / derivativeValue;
            result = newResult;
            Double newValue = (Double) function.apply(result);
            if (Math.abs(newValue) <= newtonRaphsonParameter.getError()) {
                return newResult;
            }
        }
        return result;
    }


}
