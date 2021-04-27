package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.Browser;
import util.GeneralUtil;
import util.PropertyUtils;

public class OpenPage {
	public int dynamicTimeOut = 0;
	public int scriptTimeOut;
	public String strBrowserType = null;
	public Logger logger = null;
	public WebDriver driver;
	public String serverSettingsName = "AggregationThreadCount";
	public String userName = "User123";
	public String userRole = "Administrators";
	public String userPassword = "password";
	public String addUserRole = "role123";
	public String editAuthorizationFunctions = "addRoles";
	public String nxtTemplateSettings = "CALENDAR.ASX";
	public String addAitionalFieldsName = "AdditionalFields123";
	public String addRetentionPoliciesName = "RetentionPolicies123";
	public String editRetentionPoliciesName = "RetentionPolicies1234";
	public String cloneRetentionPoliciesName = "RetentionPolicies1235";
	public String casPath;

	@BeforeClass
	public void beforeClass() throws Exception {
		// Read general timings from properties file
		dynamicTimeOut = Integer.valueOf(PropertyUtils
				.getConfigMessage("DynamicTimeOut"));

		scriptTimeOut = Integer.valueOf(PropertyUtils
				.getConfigMessage("ScriptTimeout"));
		
		strBrowserType = PropertyUtils.getConfigMessage("Browser");
		
		casPath = PropertyUtils.getConfigMessage("CAS_Path");
		
		// Defined all properties and Configure log4j
		GeneralUtil.configureLog4j("Admin Authorizations");
		// Assign logger object
		GeneralUtil.logger("Admin Authorizations");
		// Create a new screenshot folder with time stamp
		GeneralUtil.createScreenshotFolder();
		
		// Initiated browser instance for browser defined in properties file
				try {
					Browser.setBrowserType(strBrowserType);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		// Create driver object for browser
		try {
			driver = Browser.getDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Lunch and login to XVA application
		try {
			Browser.NavigateToURL();
			Common.loginToXVA();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Test(alwaysRun=true)
	public void admin_verifyAdminTabs() throws Exception {
		try {
			GeneralUtil.logger.info("Step62 : Verify Admin Items");

			// Validating Admin Tab is expand or not and verify Admin sub tabs
			if (driver
					.findElement(
							By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Server Monitor']"))
					.isDisplayed()) {
				String strServerMonitorXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Server Monitor']";
				VerifyElementPresent("Server Monitor", strServerMonitorXpath,
						dynamicTimeOut);

				String strAuthorizationsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Authorizations']";
				VerifyElementPresent("Authorizations", strAuthorizationsXpath,
						dynamicTimeOut);

				String strTemplateSettingsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[3]/div/div/div[text() ='Template Settings']";
				VerifyElementPresent("Template Settings",
						strTemplateSettingsXpath, dynamicTimeOut);

				String strAdditionalFieldsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[4]/div/div/div[text() ='Additional Fields']";
				VerifyElementPresent("Additional Fields",
						strAdditionalFieldsXpath, dynamicTimeOut);

				String strRetentionPoliciesXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[5]/div/div/div[text() ='Retention Policies']";
				VerifyElementPresent("Retention Policies",
						strRetentionPoliciesXpath, dynamicTimeOut);
			}
			// Expand Admin Tab and verify Admin sub tabs
			else {
				driver.findElement(
						By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div/Strong[text()='Admin']"))
						.click();

				String strServerMonitorXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Server Monitor']";
				VerifyElementPresent("Server Monitor", strServerMonitorXpath,
						dynamicTimeOut);

				String strAuthorizationsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Authorizations']";
				VerifyElementPresent("Authorizations", strAuthorizationsXpath,
						dynamicTimeOut);

				String strTemplateSettingsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[3]/div/div/div[text() ='Template Settings']";
				VerifyElementPresent("Template Settings",
						strTemplateSettingsXpath, dynamicTimeOut);

				String strAdditionalFieldsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[4]/div/div/div[text() ='Additional Fields']";
				VerifyElementPresent("Additional Fields",
						strAdditionalFieldsXpath, dynamicTimeOut);

				String strRetentionPoliciesXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[5]/div/div/div[text() ='Retention Policies']";
				VerifyElementPresent("Retention Policies",
						strRetentionPoliciesXpath, dynamicTimeOut);
			}
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			throw new Exception(e);
			
		}

	}


	@AfterClass
	public void afterClass() throws Exception {
		driver.quit();
		Thread.sleep(3000);
		//Common.loginOffXVA();
	}

	public void VerifyElementPresent(String strTrade, String strXpath,
			int timeOut) {
		try {
			boolean blnFind = GeneralUtil.waitUntilExists(strXpath, "xpath",
					timeOut);
			if (blnFind)
				GeneralUtil.logger.info(strTrade
						+ " MarketData item is displayed with given xpath: "
						+ strXpath);
			else
				GeneralUtil.logger
						.error(strTrade
								+ " MarketData item is not displayed with given xpath: "
								+ strXpath);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			GeneralUtil.logger
					.error("Element is not displayed.Detailes are Locator:"
							+ strXpath + " LocatorType:xpath WaitTime:"
							+ timeOut);
		}
	}

	public String getToday(String format) {
		Date date = new Date();
		return new SimpleDateFormat(format).format(date);
	}

}

