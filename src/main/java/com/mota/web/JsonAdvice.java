package com.mota.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@ControllerAdvice(basePackages= "com.mota.controller")
public class JsonAdvice extends AbstractJsonpResponseBodyAdvice{

	public JsonAdvice(){
		super("callback");
	}

}
