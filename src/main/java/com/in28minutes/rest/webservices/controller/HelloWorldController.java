package com.in28minutes.rest.webservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.beans.HelloWorldBean;

//Controller
@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSoruce;

	// GET
	// URI - /hello-world
	// method - "Hello World"
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	// hello-world-bean
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	// hello-world-bean/in28Minutes
	@GetMapping(path = "/hello-world-bean/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World %s", name));
	}

	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return messageSoruce.getMessage("good.morning.message", null,  locale);
	}
	
	@GetMapping(path = "/hello-world-internationalized-context")
	public String helloWorldInternationalizedContext() {
		return messageSoruce.getMessage("good.morning.message",
				null,  LocaleContextHolder.getLocale());
	}

}
