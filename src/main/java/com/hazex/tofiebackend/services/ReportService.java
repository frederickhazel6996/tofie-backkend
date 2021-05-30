package com.hazex.tofiebackend.services;

import com.hazex.tofiebackend.entities.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportService extends MongoRepository<Report,String> {

}
