package com.meetup.contactmanager.serializers;

import au.com.bytecode.opencsv.CSVReader;
import com.meetup.contactmanager.entities.Company;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class CsvSerializer implements Serializer {

    @Override
    public List<Company> deserialize(InputStream inputStream) {
        List<Company> companies = new LinkedList<Company>();
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(inputStream, "UTF8"));
            String[] nextLine;
            
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                
            }
        } catch(Exception e) {
            //TODO: handle exception
        }
        
        return companies;
    }

    /*@Override
    public Object deserialize(InputStream inputStream) {
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(inputStream, "UTF8"));
            String[] nextLine;
            
            
        } catch(Exception e) {
            //TODO: handle exception
        }
        
        return true;
    }*/
}