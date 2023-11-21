package com.example.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.interview.model.Interviewee;
import com.example.interview.repo.IntervieweeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/interviewee")
public class IntervieweeController {

      @Autowired
      IntervieweeRepository intervieweeRepository;

      @GetMapping
      public List<Interviewee> getAllInterviewee() {

            return intervieweeRepository.findAll();
      }
}
