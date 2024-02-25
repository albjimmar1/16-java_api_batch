package com.example.batch.services;

import com.example.batch.BatchApplication;
import com.example.batch.builders.ResponseBuilder;
import com.example.batch.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Date;
import java.util.List;

@Service
public class CSVHandlerService {

    final Logger log = LoggerFactory.getLogger(CSVHandlerService.class);

    public ResponseBuilder addToCSV(String fileName, Person person) {
        person.setRegistrationDate(new Date());
        File file = new File(BatchApplication.FILES_PATH + fileName + ".csv");
        person.setId(lastIndexCSV(file));
        boolean success = false;
        try {
            FileWriter fw = new FileWriter(file, true);
            if (person.getId() == 0) {
                fw.append(person.toCSV());
            } else {
                fw.append("\n").append(person.toCSV());
            }
            fw.close();
            success = true;
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return success ? new ResponseBuilder(person, HttpStatus.CREATED) : new ResponseBuilder(null, HttpStatus.CONFLICT);
    }

    private long lastIndexCSV(File file) {
        long lastIndex = -1;
        try {
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                List<String> lines = br.lines().toList();
                if (!lines.isEmpty())
                    lastIndex = Long.parseLong(lines.get(lines.size()-1).split(";")[0]);
                fr.close();
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return ++lastIndex;
    }

}
