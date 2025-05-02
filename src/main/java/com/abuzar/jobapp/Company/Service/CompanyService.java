package com.abuzar.jobapp.Company.Service;

import com.abuzar.jobapp.Company.Entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    boolean updateCompany(Company company, Long id);

    void createCompany(Company company);

    boolean deleteCompany(Long id);
}
