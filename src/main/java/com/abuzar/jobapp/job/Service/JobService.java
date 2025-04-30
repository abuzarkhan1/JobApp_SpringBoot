package com.abuzar.jobapp.job.Service;


import com.abuzar.jobapp.job.Entity.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();
    void createJob(Job job);

    Job getJobById(Long id);
}
