package by.htp.db.dao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import by.htp.db.dao.impl.BookMySqlDAO;
import by.htp.db.domain.entity.Book;

//Test Class
public class BookMySqlDaoTest {

	private static BookDao bookDao;

	@BeforeClass
	public static void initDao() {
		bookDao = new BookMySqlDAO();
	}

	@Test
	public void testFetchBooks() {
		List<Book> books = bookDao.fetchBooks();
		assertTrue("Size more than zero", books.size() > 0);
	}

	@Test
	public void testFetchBookWithDate(){
		GregorianCalendar calendar = new GregorianCalendar(2017, Calendar.JANUARY, 1);
		List<Book> bookList = bookDao.fetchBooks(calendar.getTime());
		assertTrue("The returned list contains zero books", bookList.size() > 0);
	}
	
	@Test
	public void testFetchBookWithDateEmptyList(){
		GregorianCalendar calendar = new GregorianCalendar(2015, Calendar.JANUARY, 1);
		List<Book> bookList = bookDao.fetchBooks(calendar.getTime());
		assertTrue("The returned list contains some books", bookList.size() == 0);
	}
	
	@Test(expected = NullPointerException.class)
	public void testFetchBooksWithNullDate() {
		bookDao.fetchBooks(null);
		fail();
	}
}
