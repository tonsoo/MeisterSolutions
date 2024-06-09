package com.meistersolutions.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.METHOD_NOT_ALLOWED,reason="Task must be PENDING to be removed")
public class TaskNotPendingOnDelete extends Exception {
    
}
