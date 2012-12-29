package se.chho.range;

public class InvalidInputException extends RuntimeException {

    private String errorCode;

    public InvalidInputException(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
