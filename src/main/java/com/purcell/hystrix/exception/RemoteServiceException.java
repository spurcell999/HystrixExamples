package com.purcell.hystrix.exception;

/**
 * Created by e026459 on 5/8/2018.
 */
public class RemoteServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RemoteServiceException(String message){
        super(message);
    }
}