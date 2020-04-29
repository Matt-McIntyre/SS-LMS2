package com.ss.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import com.ss.lms.dao.*;
import com.ss.lms.entity.*;

public class AdminService {

	public ConnectionUtil connUtil = new ConnectionUtil();
	public LibraryBranch branchSelection = null;
	public Book bookSelection = null;
	public BookCopies copiesSelection = null;
	public Borrower borrowerSelection = null;

	///////// Borrower //////////
	
	public Borrower getBorrowerByCardNo(Integer userCardNo) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BorrowerDAO dao = new BorrowerDAO(conn);
			return dao.getBorrowerByCardNo(userCardNo);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
	/// BOOK LOANS /// 
	
	public List<Book> booksBorrowed(LibraryBranch b, Borrower br){
		Connection conn = null;
		conn = connUtil.getConnection();
		BookLoansDAO dao = new BookLoansDAO(conn);
		try {
			return dao.booksBorrowed(b, br);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void borrowBook() {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookLoansDAO dao = new BookLoansDAO(conn);
			LocalDateTime out = LocalDateTime.now();
			LocalDateTime due = out.plusDays(7);
			dao.borrowBook(branchSelection, borrowerSelection, bookSelection, out, due);
			dao.reduceCopies(branchSelection, bookSelection);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void returnBook() {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookLoansDAO dao = new BookLoansDAO(conn);
			LocalDateTime in = LocalDateTime.now();
			dao.returnBook(branchSelection, borrowerSelection, bookSelection, in);
			dao.addCopies(branchSelection, bookSelection);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public List<BookCopies> getAvailibleBooks(LibraryBranch branch){
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookLoansDAO dao = new BookLoansDAO(conn);
			return dao.readAvailibleBooksByBranch(branch);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
	///////// Library Branch //////////

	public List<LibraryBranch> readAllBranches() {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO libDAO = new LibraryBranchDAO(conn);
			return libDAO.readAll();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateBranches(LibraryBranch branch) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO libDAO = new LibraryBranchDAO(conn);
			libDAO.updateBranch(branch);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
///////// BOOK COPIES//////////
	
	public List<BookCopies> readBooksWithAuthListByBranch(LibraryBranch branch){
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			CopiesDAO dao = new CopiesDAO(conn);
			return dao.readAllBooksByBranch(branch);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void updateNoCopies(BookCopies copies){
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			CopiesDAO dao = new CopiesDAO(conn);
			dao.updateNoCopies(copies);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	

///////// AUTHOR //////////

	public void saveAuthor(Author author) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			if (author.getAuthorId() != null && author.getAuthorName() != null) {
				adao.updateAuthor(author);
			} else if (author.getAuthorId() != null) {
				adao.deleteAuthor(author);
			} else {
				adao.addAuthor(author);
			}
			conn.commit(); // transaction
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public List<Author> readAuthors(Integer pk, String authorName) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			BookDAO bdao = new BookDAO(conn);
			if (pk != null) {
				// get author by primary key
			} else if (authorName != null) {
				// searchAuthors
			} else {
				List<Author> authors = adao.readAllAuthors();
				for (Author a : authors) {
					a.setBooks(bdao.readAllBooksByAuthor(a));
				}
				return authors;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return null;
	}

}
