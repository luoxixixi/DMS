package com.DMS.ghb.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.DMS.ghb.dao.CompanyDao;
import com.DMS.ghb.entity.Company;

public class CompanyDaoImpl extends HibernateDaoSupport implements CompanyDao {

	@Override
	public boolean saveCompany(Company company) {
		try {
			getHibernateTemplate().save(company);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updataCompany(Company company) {
		try {
			getHibernateTemplate().update(company);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCompany(Company company) {
		try {
			getHibernateTemplate().delete(company);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Company getComByUser(Company company) {
		try {
			String hql = "from Company where stuId=?";
			List<Company> companies = (List<Company>) getHibernateTemplate()
					.find(hql, company.getStuId().getStuId());
			if (companies != null && companies.size() > 0) {
				return companies.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getCompaniesAll() {
		try {
			String hql = "from Company";
			List<Company> companies = (List<Company>) getHibernateTemplate()
					.find(hql);
			if (companies != null && companies.size() > 0) {
				return companies;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}