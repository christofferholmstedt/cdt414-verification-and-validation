package se.chho.range;

public class InvalidRangeException extends RuntimeException {

    private String errorCode;

    public InvalidRangeException(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
