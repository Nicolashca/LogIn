package Pin;

public class PinException extends Exception {
    String errMsg;
    public PinException(String errorMessage) {
        errMsg = errorMessage;
    }

    public String getMessage()
    {
        return errMsg;
    }
}