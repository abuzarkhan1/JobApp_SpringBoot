package com.abuzar.jobapp.job.Controller;

import com.abuzar.jobapp.job.Entity.Job;
import com.abuzar.jobapp.job.Service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/jobs")
public class JobController {


    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){

        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job created", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if (job == null) {
            throw new RuntimeException("Job not found with id: " + id);
        }
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job){
        boolean updated = jobService.updateJob(id, job);
        if (!updated) {
            return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Job updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if (deleted)
            return new ResponseEntity<>("Job deleted", HttpStatus.OK);
        else
            return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }

}
