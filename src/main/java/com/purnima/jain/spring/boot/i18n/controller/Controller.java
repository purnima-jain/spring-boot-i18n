package com.purnima.jain.spring.boot.i18n.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/spring-boot-i18n")
public class Controller {

	@Autowired
	private MessageSource messageSource;

	@GetMapping(value = "/getMessageInAcceptHeaderLanguage")
	public String getMessageInAcceptHeaderLanguage() {
		String messageCode = "1234";
		String messageInAcceptHeaderLanguage = getMessage(messageCode);
		return messageInAcceptHeaderLanguage;
	}

	private String getMessage(String key) {
		return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
	}

}
