package com.filter.filterDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.filter.filterDemo.headerContext.RequestHeaderContext;

@Controller  
@RequestMapping("h1")  
public class TestController {  
  
    @RequestMapping(value = "h2")  
    public @ResponseBody Object testHeaderContext() {  
        return RequestHeaderContext.getInstance().getUserId();  
    }  
}  