package com.example.interview.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.interview.model.Interviewer;

public interface InterviewerRepository extends JpaRepository<Interviewer, Long> {

}
