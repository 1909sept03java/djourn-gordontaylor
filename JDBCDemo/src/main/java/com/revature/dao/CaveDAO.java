package com.revature.dao;

import java.io.IOException;
import java.util.List;

import com.revature.beans.CEmployee;

public interface CaveDAO {

	public List<CEmployee> getCaves() throws IOException;
	public CEmployee getCaveById(int id) throws IOException;
	public void createCave(CEmployee cave);
	public void updateCave(CEmployee cave);
	public void deleteCave(CEmployee cave);
	
}
