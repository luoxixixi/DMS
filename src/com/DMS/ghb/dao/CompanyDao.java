package com.DMS.ghb.dao;

import java.util.List;

import com.DMS.ghb.entity.Company;

public interface CompanyDao {
	public boolean saveCompany(Company company);
	public boolean updataCompany(Company  company);
	public boolean deleteCompany(Company company);
	public Company getComByUser(Company company);
	public List<Company> getCompaniesAll();
	public Company getCompanyById(String id);
}
