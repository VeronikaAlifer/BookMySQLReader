package by.htp.db.service.impl;

import java.util.Date;
import java.util.List;

import by.htp.db.dao.BookDao;
import by.htp.db.dao.impl.BookMySqlDAO;
import by.htp.db.domain.entity.Book;
import by.htp.db.domain.vo.Catalog;
import by.htp.db.service.CatalogService;

public class DefaultCatalogImpl implements CatalogService {
	
	private BookDao dao;
	
	{
		//TODO Change to factory
		dao = new BookMySqlDAO();
	}

	@Override
	public Catalog getCatalog() {

		Catalog catalog = new Catalog();
		List<Book> books = dao.fetchBooks();
		
		catalog.setTitle("New catalog of books");
		catalog.setDateCreation(new Date());
		catalog.setBooks(books);
		
		return catalog;
	}

	@Override
	public Catalog getCatalog(Date date) {
		Catalog catalog = new Catalog();
		List<Book> books = dao.fetchBooks(date);
		
		catalog.setTitle("New catalog of books");
		catalog.setDateCreation(new Date());
		catalog.setBooks(books);
		
		return catalog;
	}

}
