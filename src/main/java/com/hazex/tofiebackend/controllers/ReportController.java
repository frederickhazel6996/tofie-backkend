package com.hazex.tofiebackend.controllers;

import com.hazex.tofiebackend.entities.Report;
import com.hazex.tofiebackend.extra.IdGenerator;
import com.hazex.tofiebackend.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/report")
public class ReportController {

    @Autowired
    ReportService service;

    @PostMapping(path = "/add-report")
    ResponseEntity<String> addReport(@Valid @RequestBody Report report)
    {
        IdGenerator idGenerator=new IdGenerator();
        String id= "REPORT"+idGenerator.getAlphaNumericString(15);
        report.setId(id);
        report.setClosed(false);
        service.save(report);
        return new ResponseEntity<>("Report Added", HttpStatus.CREATED);
    }

    @PostMapping(path = "/update-report")
    ResponseEntity<Object> updateReport(@Valid @RequestBody Report report)
    {
        Optional<Report> reportData=service.findById(report.getId());

        if(reportData.isPresent())
        {
            reportData.get().setClosed(true);
            service.save(reportData.get());
            return new ResponseEntity<>(reportData,HttpStatus.CREATED);
        }

        else{
            return new ResponseEntity<>("Report Not Found",HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping(path="/get-reports")
    ResponseEntity<Object> getReports()
    {

        List<Report> reportData=service.findAll();
        return new ResponseEntity<>(reportData,HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete-report/{id}")
    ResponseEntity<String> deleteReport(@PathVariable String id)
    {
        service.deleteById(id);
        return new ResponseEntity<>("Report Deleted",HttpStatus.CREATED);
    }



}
