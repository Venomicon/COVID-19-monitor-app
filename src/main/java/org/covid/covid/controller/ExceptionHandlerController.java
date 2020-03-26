package org.covid.covid.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.exceptions.TemplateProcessingException;

import java.net.URISyntaxException;

@ControllerAdvice
public class ExceptionHandlerController {
    public static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(URISyntaxException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ModelAndView handleURISyntaxException(URISyntaxException e) {
        String message = "Country not found in the database";
        LOGGER.error(message);
        ModelAndView modelAndView = new ModelAndView("error/errorPage");
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @ExceptionHandler({Exception.class, TemplateProcessingException.class, SpelEvaluationException.class, NullPointerException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ModelAndView handleUnirestException(Exception e) {
        String message = "Unable to process your request";
        LOGGER.error(e.getMessage());
        ModelAndView modelAndView = new ModelAndView("error/errorPage");
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
