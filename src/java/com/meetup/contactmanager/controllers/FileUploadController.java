package com.meetup.contactmanager.controllers;

import au.com.bytecode.opencsv.CSVReader;
import com.meetup.contactmanager.entities.Company;
import com.meetup.contactmanager.entities.Contact;
import com.meetup.contactmanager.services.CompanyService;
import com.meetup.contactmanager.services.ContactService;
import com.meetup.contactmanager.validators.DataValidator;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/data")
public class FileUploadController {
    
    @Autowired
    private CompanyService companyService;
    
    @Autowired
    private ContactService contactService;
    
    @Autowired
    private DataValidator dataValidator;
    
    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public String form() {
        return "/data/upload";
    }
    
    @RequestMapping(value="/upload/csv", method=RequestMethod.POST)
    public String upload(@RequestParam(value="file", required=false) MultipartFile uploadedFile, ModelMap map) throws FileNotFoundException {
        String dateFormat = "dd/MM/yyyy";
        
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(uploadedFile.getInputStream(), "UTF8"));
            String[] nextLine;
            
            Map<String, Company> companyMap = new LinkedHashMap<String, Company>();
            List<String> invalidRecords = new LinkedList<String>();
            
            //read first line which is header
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                if (dataValidator.validate(nextLine) == true) {
                    Company company = new Company();
                    
                    //check to see if the company is a duplicate by keeping them
                    //in a map.  if it already exists in the file get it from the map
                    //else create a new company.
                    if (companyMap.containsKey(nextLine[4])) {
                        company = companyMap.get(nextLine[4]);
                    } else {
                        company = companyService.deserialize(nextLine);
                        companyMap.put(nextLine[4], company);
                    }
                    
                    Contact contact = contactService.deserialize(nextLine, dateFormat);
                    contact.setCompany(company);
                    company.getContacts().add(contact);
                } else {
                    StringBuilder errorMessage = new StringBuilder();
                    errorMessage.append("Record with ").append("User ID ").append(nextLine[1]).append(" contains invalid data and was not saved.");
                    invalidRecords.add(errorMessage.toString());
                }
                map.addAttribute("invalidRecords", invalidRecords);
            }
            //loop through map to get company objects and save them
            for (String companyName : companyMap.keySet()) {
                companyService.save(companyMap.get(companyName));
            }
        } catch(Exception e) {
            //TODO: add exception handling
            String message = e.getMessage();
        }
        
        return "/data/upload";
    }
}