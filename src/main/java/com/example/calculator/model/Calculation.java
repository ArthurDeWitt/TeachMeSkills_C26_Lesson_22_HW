package com.example.calculator.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Calculation {

    private double firstNumber;
    private double secondNumber;
    private String operation;
    private Double result;

    public Calculation() {

    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Calculation)) return false;
        final Calculation other = (Calculation) o;
        if (!other.canEqual((Object) this)) return false;
        if (Double.compare(this.getFirstNumber(), other.getFirstNumber()) != 0) return false;
        if (Double.compare(this.getSecondNumber(), other.getSecondNumber()) != 0) return false;
        final Object this$operation = this.getOperation();
        final Object other$operation = other.getOperation();
        if (this$operation == null ? other$operation != null : !this$operation.equals(other$operation)) return false;
        final Object this$result = this.getResult();
        final Object other$result = other.getResult();
        if (this$result == null ? other$result != null : !this$result.equals(other$result)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Calculation;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $firstNumber = Double.doubleToLongBits(this.getFirstNumber());
        result = result * PRIME + (int) ($firstNumber >>> 32 ^ $firstNumber);
        final long $secondNumber = Double.doubleToLongBits(this.getSecondNumber());
        result = result * PRIME + (int) ($secondNumber >>> 32 ^ $secondNumber);
        final Object $operation = this.getOperation();
        result = result * PRIME + ($operation == null ? 43 : $operation.hashCode());
        final Object $result = this.getResult();
        result = result * PRIME + ($result == null ? 43 : $result.hashCode());
        return result;
    }

    public String toString() {
        return "Calculation(firstNumber=" + this.getFirstNumber() + ", secondNumber=" + this.getSecondNumber() + ", operation=" + this.getOperation() + ", result=" + this.getResult() + ")";
    }
}
