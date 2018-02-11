package com.DMS.ghb.service;

import java.util.List;

import com.DMS.ghb.entity.Papers;

public interface PapersService {
	public boolean savePaper(Papers paper);
	public List<Papers> getpPapersByUser(String Userid);
	public Papers getPaperById(String id);
	public List<Papers> getPaper();
	public boolean updataPaper(Papers paper);
	public boolean deletePaper(Papers paper);
}
