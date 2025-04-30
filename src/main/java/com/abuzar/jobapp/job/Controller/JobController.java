package com.abuzar.jobapp.job.Controller;

import com.abuzar.jobapp.job.Entity.Job;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/jobs")
public class JobController {

    private List<Job> jobs = new ArrayList<>();

    @GetMapping
    public List<Job> findAll(){
        return jobs;
    }

    @PostMapping
    public String createJob(@RequestBody Job job){
        jobs.add(job);
        return "Job created successfully";
    }

}
