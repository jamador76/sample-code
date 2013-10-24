package com.meetup.contactmanager.controllers;

import com.meetup.contactmanager.services.CompanyService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String list(ModelMap map, HttpServletRequest request) {
        map.addAttribute("contextPath", request.getContextPath());
        map.addAttribute("list", companyService.list());
        return "/company/list";
    }
}