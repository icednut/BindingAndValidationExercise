package org.springstudy.common.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author wangeun.lee@sk.com
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private ApplicationContext applicationContext;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleBindException(Exception bindException) {
        String bindMessage = bindException.getMessage();
//        String message = applicationContext.getMessage(bindMessage, null, Locale.getDefault());

        System.out.println("******************** bindMessage: " + bindMessage);
        return new ResponseEntity(bindMessage, HttpStatus.BAD_REQUEST);
    }

}
