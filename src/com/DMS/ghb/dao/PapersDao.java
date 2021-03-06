package com.DMS.ghb.dao;

import java.util.List;

import com.DMS.ghb.entity.Papers;

public interface PapersDao {
	public boolean savePapers(Papers papers);
	public boolean updataPapers(Papers papers);
	public boolean deletePapers(Papers papers);
	public Papers getPapersById(String id);
	public List<Papers> getPapersAll();
	public List<Papers> getPapersByUSer(long stuId);
	public Papers getStuPaper(String stuId,String mId);
}
