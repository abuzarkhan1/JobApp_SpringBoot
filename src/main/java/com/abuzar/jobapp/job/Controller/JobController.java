package com.abuzar.jobapp.job.Controller;

import com.abuzar.jobapp.job.Entity.Job;
import com.abuzar.jobapp.job.Service.JobService;
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
    public List<Job> findAll(){

        return jobService.findAll();
    }

    @PostMapping
    public String createJob(@RequestBody Job job){
        jobService.createJob(job);
        return "Job created successfully";
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if (job == null) {
            throw new RuntimeException("Job not found with id: " + id);
        }
        return job;
    }

}
