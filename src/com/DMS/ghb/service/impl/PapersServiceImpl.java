package com.DMS.ghb.service.impl;

import java.util.List;

import com.DMS.ghb.dao.PapersDao;
import com.DMS.ghb.entity.Papers;
import com.DMS.ghb.service.PapersService;

public class PapersServiceImpl implements PapersService{
	private PapersDao dao;

	public PapersDao getDao() {
		return dao;
	}

	public void setDao(PapersDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean savePaper(Papers paper) {
		boolean savePapers = dao.savePapers(paper);
		return savePapers;
	}

	@Override
	public List<Papers> getpPapersByUser(String Userid) {
		long stuId = Long.parseLong(Userid);
		List<Papers> papersByUSer = dao.getPapersByUSer(stuId);
		return papersByUSer;
	}

	@Override
	public Papers getPaperById(String id) {
		Papers papersById = dao.getPapersById(id);
		return papersById;
	}

	@Override
	public List<Papers> getPaper() {
		List<Papers> papersAll = dao.getPapersAll();
		if(papersAll!=null){
			return papersAll;
		}
		return null;
	}

	@Override
	public boolean updataPaper(Papers paper) {
		boolean updataPapers = dao.updataPapers(paper);
		return updataPapers;
	}

	@Override
	public boolean deletePaper(Papers paper) {
		boolean deletePapers = dao.deletePapers(paper);
		return deletePapers;
	}

}
