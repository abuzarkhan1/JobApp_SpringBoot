package com.abuzar.jobapp.Company.Controller;

import com.abuzar.jobapp.Company.Entity.Company;
import com.abuzar.jobapp.Company.Service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable  Long id, @RequestBody Company company) {
        boolean isUpdated = companyService.updateCompany(company, id);
        if (isUpdated) {
            return ResponseEntity.ok("Company updated successfully");
        } else {
            return ResponseEntity.status(404).body("Company not found");
        }
    }
}
