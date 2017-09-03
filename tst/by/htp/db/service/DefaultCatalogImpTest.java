package by.htp.db.service;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import by.htp.db.domain.vo.Catalog;
import by.htp.db.service.impl.DefaultCatalogImpl;

public class DefaultCatalogImpTest {

	private static CatalogService service;

	@BeforeClass
	public static void initCatalogServiceTest() {
		service = new DefaultCatalogImpl();
	}

	@Test
	public void testCatalogNotNull() {
		Catalog catalog = service.getCatalog();
		assertNotNull("The catalog was not created", catalog);
	}

	@Test
	public void testCatalogEmptyFields() {
		Catalog catalog = service.getCatalog();
		assertNotNull("The catalog title was not filled", catalog.getTitle());
		assertNotNull("The date of creation was not set", catalog.getDateCreation());
		assertNotNull("The books list was not attached to catalog item", catalog.getBooks());
	}

	@Test
	public void testCatalogEmptyBooks() {
		Catalog catalog = service.getCatalog();
		assertNotNull("The books list was not attached to catalog item", catalog.getBooks());
		assertTrue("The books list is empty", catalog.getBooks().size() > 0);
	}

	@Test
	public void testGetCatalogWithDate() {
		GregorianCalendar calendar = new GregorianCalendar(2015, Calendar.JANUARY, 1);
		Catalog catalog = service.getCatalog(calendar.getTime());
		assertNotNull("The catalog title was not filled", catalog.getTitle());
		assertNotNull("The date of creation was not set", catalog.getDateCreation());
		assertNotNull("The books list was not attached to catalog item", catalog.getBooks());
	}

	@Test(expected = NullPointerException.class)
	public void testGetCatalogWithNullDate() {
		service.getCatalog(null);
		fail();
	}
}
