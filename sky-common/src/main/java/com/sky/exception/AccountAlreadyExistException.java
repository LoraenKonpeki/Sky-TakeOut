package com.sky.exception;

/**
 * 账号重复异常
 */
public class AccountAlreadyExistException extends BaseException {

    public AccountAlreadyExistException() {
    }

    public AccountAlreadyExistException(String msg) {
        super(msg);
    }

}
