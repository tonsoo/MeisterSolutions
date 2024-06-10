package com.meistersolutions.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Could not find the specified task")
public class TaskNotFoundException extends Exception {
    
}
