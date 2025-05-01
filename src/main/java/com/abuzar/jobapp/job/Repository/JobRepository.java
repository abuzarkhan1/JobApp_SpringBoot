package com.abuzar.jobapp.job.Repository;

import com.abuzar.jobapp.job.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository  extends JpaRepository<Job, Long> {

}
