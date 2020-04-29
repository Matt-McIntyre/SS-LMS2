package com.ss.lms.service;

import java.sql.SQLException;
import java.util.List;

import com.ss.lms.dao.LibraryBranchDAO;
import com.ss.lms.entity.LibraryBranch;

public class LibrarianService {
	
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<LibraryBranch> readAllBranches() {
		LibraryBranchDAO libDAO = new LibraryBranchDAO(connUtil.getConnection());
		System.out.println("Query DB");
		try {
			return libDAO.readAll();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
}
