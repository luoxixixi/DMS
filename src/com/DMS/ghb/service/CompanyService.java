package com.DMS.ghb.service;

import java.util.List;

import com.DMS.ghb.entity.Company;

public interface CompanyService {
	public boolean saveCompany(Company company);
	public List<Company> getCompanyByUser(String Userid);
	public List<Company> getCompany();
	public boolean updataCompany(Company major);
	public boolean deleteCompany(Company major);
}
