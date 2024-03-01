package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BookShelvesPage;
import testBase.BaseClass;

public class TC_002_SelectItems extends BaseClass {

	@Test(priority = 1)
	public void selectCategory() {
		
		logger.info("*** Starting TC_002_Select Items***");
		logger.info("*** Selecting Category***");
		try {
			// BookShelvesPage
			BookShelvesPage BS = new BookShelvesPage(driver);
			BS.handle_alert();
			BS.category_click();
		} catch (Exception e) {
			System.out.println(e);
			logger.info(e);
		}
	}

	
	@Test(priority = 2)
	public void select_price() {
		
		logger.info("*** Selecting price***");
		try {
			// BookShelvesPage
			BookShelvesPage BS = new BookShelvesPage(driver);
			BS.price_slider();
		} catch (Exception e) {
			System.out.println(e);
			logger.info(e);
		}
	}

	
	@Test(priority = 3)
	public void clickStorageButton() {
	
		logger.info("*** Clicking Storage Button***");
		try {
			// BookShelvesPage
			BookShelvesPage BS = new BookShelvesPage(driver);

			BS.storage_checkbox();
		} catch (Exception e) {
			System.out.println(e);
			logger.info(e);
		}
	}

	
	@Test(priority = 4)
	public void select_filter() {
	
		logger.info("*** Selecting filter***");
		try {
			// BookShelvesPage
			BookShelvesPage BS = new BookShelvesPage(driver);
			BS.sort_dropDown();
		} catch (Exception e) {
			System.out.println(e);
			logger.info(e);
		}
	}

	
	@Test(priority = 5, dependsOnMethods = "select_filter")
	public void print_data() throws IOException {
		
		logger.info("*** printing Bookshelves data in Excel and Console***");
		try {
			BookShelvesPage BS = new BookShelvesPage(driver);
			System.out.println("-----------Name and Price of the Books-----------");
			BS.print_BookshelvesData();
			BS.print_BSExceldata();
		} catch (Exception e) {
			System.out.println(e);
			logger.info(e);
		}
	}

	
	@Test(priority = 6)
	public void displayNavBar_items() throws IOException {
		
		logger.info("*** Displaying Navbar items***");
		try {
			BookShelvesPage BS = new BookShelvesPage(driver);

			BS.clickNavbutton();
		} catch (Exception e) {
			System.out.println(e);
			logger.info(e);
		}
	}

	
	@Test(priority = 7, dependsOnMethods="displayNavBar_items")
	public void printNavBar_items() throws IOException {
		
		logger.info("*** Printing Navbar items***");
		try {
			BookShelvesPage BS = new BookShelvesPage(driver);
			Thread.sleep(2000);
			System.out.println("-------------------Values of Living Storage--------------------");
			BS.printNavExceldata();

		} catch (Exception e) {
			System.out.println(e);
			logger.info(e);
		}
		logger.info("*** Completed TC_002_Select Items***");
	}
}
