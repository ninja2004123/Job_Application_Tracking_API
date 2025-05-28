package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.config.WebMvcConfig;
import com.example.model.Conducts;
import com.example.model.Employee;
import com.example.model.Interview;
import com.example.service.ConductsService;
import com.example.service.EmployeeService;
import com.example.service.InterviewService;

@RestController
@RequestMapping("/conducts")
public class ConductsController {
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);
    

    @Autowired
    private ConductsService conductsService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private InterviewService interviewService;

    
    @GetMapping
    public List<Conducts> getAllConductss() {
        return conductsService.getAllConductss();
    }

    @GetMapping("/{conductsId}")
    public Optional<Conducts> getConducts(@PathVariable Long conductsId) {
        return conductsService.getConducts(conductsId);
    }

    @PostMapping
    public Conducts createConducts(@RequestBody ConductsRequest conducts) {
        try {
            Employee employee = employeeService.getEmployee(conducts.employeeId).orElseThrow(() -> new RuntimeException("Interviewer not found."));
            Interview interview = interviewService.getInterview(conducts.interviewId).orElseThrow(() -> new RuntimeException("Interview not found."));

            Conducts conducts_ = new Conducts();
            conducts_.setInterview(interview);
            conducts_.setInterviewer(employee);

            return conductsService.saveConducts(conducts_);
        } catch (Exception e) {
            logger.warn(e.getMessage()); 
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{conductsId}")
    public Conducts updateConducts(@PathVariable Long conductsId, @RequestBody ConductsRequest conducts) {
        try {
            Employee employee = employeeService.getEmployee(conducts.employeeId).orElseThrow(() -> new RuntimeException("Interviewer not found."));
            Interview interview = interviewService.getInterview(conducts.interviewId).orElseThrow(() -> new RuntimeException("Interview not found."));

            Conducts conducts_ = new Conducts();
            conducts_.setConductsId(conductsId);
            conducts_.setInterview(interview);
            conducts_.setInterviewer(employee);

            return conductsService.saveConducts(conducts_);
        } catch (Exception e) {
            logger.warn(e.getMessage()); 
            return null;
        }
    }

    @DeleteMapping("/{conductsId}")
    public void deleteConducts(@PathVariable Long conductsId) {
        conductsService.deleteConducts(conductsId);
    }
    
    // So we can take the Conducts requests:
    public static class ConductsRequest {
        public Long employeeId;
        public Long interviewId;
    }
}


