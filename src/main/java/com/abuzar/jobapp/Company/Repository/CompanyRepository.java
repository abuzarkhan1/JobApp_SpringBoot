package com.abuzar.jobapp.Company.Repository;

import com.abuzar.jobapp.Company.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository  extends JpaRepository<Company, Long> {
}
