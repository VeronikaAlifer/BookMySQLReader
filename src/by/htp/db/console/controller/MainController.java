package by.htp.db.console.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;

import by.htp.db.console.view.ConsoleOutput;
import by.htp.db.console.view.impl.SimpleConsoleOutput;
import by.htp.db.domain.vo.Catalog;
import by.htp.db.service.CatalogService;
import by.htp.db.service.impl.DefaultCatalogImpl;

public class MainController {

	public static void main(String[] args) {
		
		ConsoleOutput output = new SimpleConsoleOutput();
		CatalogService service = new DefaultCatalogImpl();
//		
//		Catalog catalog = service.getCatalog();
//		output.printCatalog(catalog);
		GregorianCalendar calendar = new GregorianCalendar(2017, Calendar.JANUARY, 1);
		Catalog catalogDate = service.getCatalog(calendar.getTime());
		output.printCatalog(catalogDate);
	}

}
