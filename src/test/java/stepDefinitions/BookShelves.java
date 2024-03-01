package stepDefinitions;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.BookShelvesPage;


public class BookShelves {
	
	
	
	BookShelvesPage BS = new BookShelvesPage(BaseClass.getDriver());
	
	@Given("the user is on the Bookshelves page")
	public void the_user_is_on_the_bookshelves_page() {
	  BaseClass.navigate();
	  BaseClass.getLogger().info("Applying filters");
	}
	@When("user close the popup")
	public void user_close_the_popup() {
	  BS.handle_alert();
	}
	@When("select category and Price")
	public void select_category_and_price() throws InterruptedException {
	   BS.category_click();
	   BS.price_slider();
	}
	@When("the user click the exclude out of box check box")
	public void the_user_click_the_exclude_out_of_box_check_box() throws InterruptedException {
	    BS.storage_checkbox();
	}
	@When("sort by high to low")
	public void sort_by_high_to_low() {
	   BS.sort_dropDown();
	}
	@Then("top three Bookshelves data will be stored in excel")
	public void top_three_bookshelves_data_will_be_stored_in_excel() throws InterruptedException, IOException {
	 BS.print_BookshelvesData();
	 BS.print_BSExceldata();
	}
	
	//NavBar submenu
	
	@When("the user clicks the living button in navbar")
	public void the_user_clicks_the_living_button_in_navbar() {
	    BS.clickNavbutton();
	}
	@Then("print the list of submenu under Living Storage Category in excel")
	public void print_the_list_of_submenu_under_living_storage_category_in_excel() throws IOException {
	    BS.printNavExceldata();
	    BaseClass.getLogger().info("Printing data in the Excel");
	}

}
