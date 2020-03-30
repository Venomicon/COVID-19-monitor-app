package org.covid.covid.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {
    public static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ModelAndView handleException(Exception e) {
        String message = "Unable to process your request";
        LOGGER.error(e.getMessage());
        ModelAndView modelAndView = new ModelAndView("error/errorPage");
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
