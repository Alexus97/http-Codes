package com.dev.jt.httpcodes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StatusBadRequestException extends RuntimeException{


}
