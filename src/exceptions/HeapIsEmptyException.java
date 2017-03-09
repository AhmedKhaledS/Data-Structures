package exceptions;

/**
 * Created by Ahmed Khaled on 09/03/2017.
 */
public class HeapIsEmptyException extends Exception {
    public HeapIsEmptyException() {
        super();
    }

    public HeapIsEmptyException(final String msg) {
        super(msg);
    }
}
