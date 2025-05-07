package com.example.mgnt_sys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mgnt_sys.model.Form;
import com.example.mgnt_sys.repository.FormRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FormController {
    
    @Autowired
    private FormRepository formRepository;
    
    @GetMapping("/form")
    public String getForm(){
        return "redirect:/form.html";
    }
    
    @PostMapping("/submit")
    @ResponseBody 
    public String handleFormSubmission(
        @RequestParam String firstname,
        @RequestParam String lastname,
        @RequestParam String country, 
        @RequestParam String subject){
    
        Form data=new Form();
        data.setFirstName(firstname);
        data.setLastName(lastname);
        data.setCountry(country);
        data.setSubject(subject);

        formRepository.save(data);
    
            return "Form Sumbitted!! --> \nFirst Name: " + firstname + ", Last Name: " + lastname +  " Country : " + country + " subject : " + subject ;
    }
    
    
}


