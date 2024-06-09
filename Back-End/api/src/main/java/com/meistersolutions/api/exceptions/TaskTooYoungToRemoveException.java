package com.meistersolutions.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.METHOD_NOT_ALLOWED,reason="Task must be at least 5 days old to be removed")
public class TaskTooYoungToRemoveException extends Exception {
    
}
