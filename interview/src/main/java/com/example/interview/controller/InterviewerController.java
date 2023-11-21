package com.example.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.interview.exception.DataFetchingException;
import com.example.interview.model.Interviewer;
import com.example.interview.repo.InterviewerRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/interviewer")
public class InterviewerController {

      @Autowired
      private InterviewerRepository interviewerRepository;

      @GetMapping
      public List<Interviewer> getAllInterviewer() {

            return interviewerRepository.findAll();
      }

      @GetMapping("{id}")
      public ResponseEntity<Interviewer> getInterviewerById(@PathVariable long id) {
            Interviewer interviewer = interviewerRepository.findById(id)
                        .orElseThrow(() -> new DataFetchingException("Interviewer does not exist with id: " + id));
            return ResponseEntity.ok(interviewer);
      }

      @PutMapping("{id}")
      public ResponseEntity<Interviewer> updaateInterviewer(@PathVariable long id,
                  @RequestBody Interviewer updatedInterviewer) {
            Interviewer interviewer = interviewerRepository.findById(id)
                        .orElseThrow(() -> new DataFetchingException("Interviewer does not exist with id: " + id));
            interviewer.setFirstName(updatedInterviewer.getFirstName());
            interviewer.setLastName(updatedInterviewer.getLastName());
            interviewer.setEmail(updatedInterviewer.getEmail());
            interviewer.setPhone(updatedInterviewer.getPhone());
            interviewerRepository.save(interviewer);

            return ResponseEntity.ok(interviewer);
      }

      @PostMapping
      public Interviewer addInterviewer(@RequestBody Interviewer interviewer) {

            return interviewerRepository.save(interviewer);
      }

      @DeleteMapping("{id}")
      public ResponseEntity<Interviewer> delecteInterviewer(@PathVariable long id) {

            Interviewer interviewer = interviewerRepository.findById(id).orElseThrow(() -> new DataFetchingException(
                        String.format("Interviewer does not exist with id: " + id)));
            interviewerRepository.delete(interviewer);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

      }

}
