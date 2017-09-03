package by.htp.db.service;

import java.util.Date;

import by.htp.db.domain.vo.Catalog;

public interface CatalogService {
	
	public Catalog getCatalog();
	public Catalog getCatalog(Date date);
}
