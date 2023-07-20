package kr.co.jhta.service.exception;

public class JhtaException extends RuntimeException {

    public JhtaException(String message) {
        super(message);
    }

    public JhtaException(String message, Throwable cause) {
        super(message, cause);
    }
}
