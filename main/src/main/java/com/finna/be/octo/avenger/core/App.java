package com.finna.be.octo.avenger.core;

import com.finna.be.octo.avenger.core.db.dao.IUserDAO;
import com.finna.be.octo.avenger.core.db.model.DBUser;
import com.finna.be.octo.avenger.db.dao.impl.UserDAO;

public class App 
{
    public static void main( String[] args )
    {
    	try {
        IUserDAO userDAO = new UserDAO();
        DBUser user = new DBUser();
        user.setId(1);
        user.setFullName("Ivan B");
        user.setUsername("baba");
		userDAO.addUser(user);
    	} catch (Exception ex) {
    		System.out.println(ex.toString());
    	}
    }
}
