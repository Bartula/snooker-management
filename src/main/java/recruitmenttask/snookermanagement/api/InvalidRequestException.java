package recruitmenttask.snookermanagement.api;

/**
 * Created by Bartosz on 2017-01-17.
 */
public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String message) {
        super(message);
    }

}
