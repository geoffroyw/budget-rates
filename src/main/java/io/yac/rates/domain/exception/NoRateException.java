package io.yac.rates.domain.exception;

/**
 * Created by geoffroy on 18/02/2016.
 */
public class NoRateException extends Exception {

    public NoRateException() {
        super();
    }

    public NoRateException(String message) {
        super(message);
    }
}
