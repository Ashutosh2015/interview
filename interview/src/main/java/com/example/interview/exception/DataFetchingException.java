package com.example.interview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataFetchingException extends RuntimeException {

      public DataFetchingException(String meaage) {
            super(meaage);
      }
}
