package com.example.interview.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.interview.model.Interviewee;

public interface IntervieweeRepository extends JpaRepository<Interviewee, Long> {

}
