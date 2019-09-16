package com.revature.dao;

import java.io.IOException;
import java.util.List;

import com.revature.beans.Cave;

public interface CaveDAO {

	public List<Cave> getCaves() throws IOException;
	public Cave getCaveById(int id) throws IOException;
	public void createCave(Cave cave);
	public void updateCave(Cave cave);
	public void deleteCave(Cave cave);
	
}
