package com.meistersolutions.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.METHOD_NOT_ALLOWED,reason="Tasks cannot be created on weekends")
public class TaskOnWeekDaysException extends Exception {
}
