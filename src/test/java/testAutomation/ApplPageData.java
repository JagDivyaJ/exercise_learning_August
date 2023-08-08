package testAutomation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilityAss.ConstantsAss;

public class ApplPageData extends BaseTestAuto {

	@Test(dataProvider = "validTestData")

	public void verifySearchCustomerEmail(String searchemail) throws Exception {
	
		System.out.println("user details are: " + searchemail);

		pf.login(ConstantsAss.username, ConstantsAss.password);

		pf.verifyDashboardVisible("Dashboard / nopCommerce administration");
		
		pf.clickCustomersMenu();
		
		pf.clickCustomersMenuItem();
		
		pf.verifyCustURL("https://admin-demo.nopcommerce.com/Admin/Customer/List");
		
		pf.enterCustEmail(searchemail);
		
		pf.clickSearchbutton();
		
		pf.verifyResultEmail(searchemail);
		
		pf.clickLogoutButton();

	}
	
	@DataProvider

	public Object[][] validTestData() {

		Object[][] data = { {"arthur_holmes@nopCommerce.com"}, {"james_pan@nopCommerce.com"}, {"admin@yourStore.com"} };

		return data;

	}

}
