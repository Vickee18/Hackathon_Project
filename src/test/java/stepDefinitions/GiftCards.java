package stepDefinitions;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.GiftCardPage;

import utilities.DataProviders;


public class GiftCards {

	
	GiftCardPage GC = new GiftCardPage(BaseClass.getDriver());
	DataProviders DP = new DataProviders(); // to get the data from the Excel

	@Then("the user should be redirected to the GiftCard page after clicking the GiftCards button")
	public void the_user_should_be_redirected_to_the_gift_card_page_after_clicking_the_GiftCards_button() {
		GC.giftcard.click();
		BaseClass.getLogger().info("Navigating to Gift Card Page");
	}

	@Then("the user have to choose Bithday\\/Anniversary button")
	public void the_user_have_to_choose_bithday_anniversary_button() {
		GC.birthday();
	}

	@Then("the user should select git amound and the delivery date")
	public void the_user_should_select_git_amound_and_the_delivery_date() {
		GC.select_amount();
		GC.month_date();
	}

	@Then("the user have to fill the sender details")
	public void the_user_have_to_fill_the_sender_details() throws IOException {
		DP.senderDetails();
	}

	@Then("the user have to fill the receiver details")
	public void the_user_have_to_fill_the_receiver_details() throws IOException {
		DP.receiverDetails();
	}

	@When("the user enters invalid email, error should be saved in excel")
	public void the_user_enters_invalid_email_it_should_validate() throws IOException, InterruptedException {
		GC.validation();
	}

	@When("the user should enter correct email")
	public void the_user_should_enter_correct_email() {
		GC.crct_mail("Dinesh183@gmail.com", "Ganesh183@gmail.com");
	}

	@Then("clicks the confirm button")
	public void clicks_the_confirm_button() {
		GC.clickConfirm();
		BaseClass.getLogger().info("Successfully completed all the steps");
	}

}
