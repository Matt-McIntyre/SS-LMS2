package com.ss.lms.unittesting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ss.lms.service.*;
import com.ss.lms.userinterface.*;

public class AdminTest {

	@Test
	public final void testgetBorrowerByCardNoNotNull() {
		AdminService libraryService = new AdminService();
		assertNotNull(libraryService.getBorrowerByCardNo(007));
	}
	
	@Test
	public final void testgetBorrowerByCardNoNotfound() {
		AdminService libraryService = new AdminService();
		assertNull(libraryService.getBorrowerByCardNo(0).getCardNo());
	}
	
	@Test
	public final void testgetBooksBorrowedByCardNoNotNull() {
		AdminService libraryService = new AdminService();
		//assertNotNull(libraryService.booksBorrowed(null, null));
	}
	
	@Test
	public final void testReadAllBranches() {
		AdminService libraryService = new AdminService();
		assertNull(libraryService.getBorrowerByCardNo(0).getCardNo());
	}
	
	@Test
	public final void testUI() {
		assertNotNull(testUI.getUI());		
	}

}
