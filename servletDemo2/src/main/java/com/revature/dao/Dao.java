package com.revature.dao;


import java.io.IOException;
import java.util.List;

import com.revature.beans.ACCOUNT;
import com.revature.beans.User;


public interface Dao {

	public List<User> getUser() throws IOException;
	public User getUserbyId(int id) throws IOException;
	
	public void updateUser(User user);
	public void deleteUser(User user);
	User createUser();
	
}

