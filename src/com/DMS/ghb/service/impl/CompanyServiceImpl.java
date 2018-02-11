package com.DMS.ghb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.DMS.ghb.dao.CompanyDao;
import com.DMS.ghb.entity.Company;
import com.DMS.ghb.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {
	private CompanyDao dao;

	public CompanyDao getDao() {
		return dao;
	}

	public void setDao(CompanyDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean saveCompany(Company company) {
		boolean saveCompany = dao.saveCompany(company);
		return saveCompany;
	}

	@Override
	public List<Company> getCompanyByUser(String Userid) {
		List<Company> list = new ArrayList<Company>();
		Company company = new Company();
		long id = Long.parseLong(Userid);
		Company comByUser = dao.getComByUser(company);
		list.add(comByUser);
		return list;
	}

	@Override
	public List<Company> getCompany() {
		List<Company> companiesAll = dao.getCompaniesAll();
		if (companiesAll != null) {
			return companiesAll;
		}
		return null;
	}

	@Override
	public boolean updataCompany(Company company) {
		boolean updataCompany = dao.updataCompany(company);
		return updataCompany;
	}

	@Override
	public boolean deleteCompany(Company company) {
		boolean deleteCompany = dao.deleteCompany(company);
		return deleteCompany;
	}

}
