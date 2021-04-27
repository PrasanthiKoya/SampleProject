package util;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Browser {

	public static WebDriver Driver;
	public static String strBrowserType;
	private static ThreadLocal<WebDriver> ThreadDriver = null;
	public static String baseUrl;
	public static String intMinWait;
	public static String intMidWait;
	public static long intMaxWait;
	public static long strPollingEvery;
	public static String browserHandle;

	public static WebDriver IntilizeBrowser() throws Exception {
		DesiredCapabilities capabilities = null;
		try {
			// Thread local is the class which creates separate instance of
			// webdriver for every thread.
			ThreadDriver = new ThreadLocal<>();
			Driver = ThreadDriver.get();

			if (strBrowserType.equalsIgnoreCase("firefox")) {
				Driver = new FirefoxDriver();
				ThreadDriver.set(Driver);
				capabilities = DesiredCapabilities.firefox();
				// System.out.println("Initiated Firefox browser instance");
				GeneralUtil.logger.info("Initiated " + strBrowserType
						+ " browser instance");
			} else if (strBrowserType.equalsIgnoreCase("IE")
					|| strBrowserType.equalsIgnoreCase("internet explorer")) {
				File file = new File(System.getProperty("user.dir")
						+ "/Resources/IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver",
						file.getAbsolutePath());
				Driver = new InternetExplorerDriver();
				ThreadDriver.set(Driver);
				capabilities = DesiredCapabilities.internetExplorer();
				// System.out.println("Initiated IE browser instance");
				GeneralUtil.logger.info("Initiated " + strBrowserType
						+ " browser instance");
			} else if (strBrowserType.equalsIgnoreCase("Chrome")) {
				File file = new File(System.getProperty("user.dir")
						+ "/Resources/chromedriver.exe");
				System.setProperty("webdriver.chrome.driver",
						file.getAbsolutePath());
				ChromeOptions options = new ChromeOptions();
				options.addArguments("chrome.switches", "--disable-extensions");
				// options.addArguments("--disable-extensions");
				Driver = new ChromeDriver(options);
				ThreadDriver.set(Driver);
				capabilities = DesiredCapabilities.chrome();
				// System.out.println("Initiated Chrome browser instance");
				GeneralUtil.logger.info("Initiated " + strBrowserType
						+ " browser instance");
			}

			// Printing capabilities
			if (capabilities != null) {
				// System.out.println(capabilities);
				// logger.info(capabilities);
			}

			/*
			 * EventFiringWebDriver efw = new EventFiringWebDriver(driver);
			 * ScreenShotListener screenShotListener = new ScreenShotListener();
			 * efw.register(screenShotListener);
			 */
		//	Driver.manage().window().maximize();
			Driver.manage()
					.timeouts()
					.setScriptTimeout(Long.valueOf(GeneralUtil.scriptTimeOut),
							TimeUnit.SECONDS);
			Driver.manage()
					.timeouts()
					.pageLoadTimeout(Long.valueOf(GeneralUtil.pageLoadTimeOut),
							TimeUnit.SECONDS);
			Driver.manage()
					.timeouts()
					.implicitlyWait(Long.valueOf(GeneralUtil.implicitTimeOut),
							TimeUnit.SECONDS);

		} catch (Exception e) {
			GeneralUtil.logger.error(strBrowserType
					+ " browser instance initiation is failed.");
			throw new Exception(e.getMessage());
		}
		return Driver;
	}

	public static void setBrowserType(String browserType) {
		strBrowserType = browserType;
	}

	public static WebDriver getDriver() throws Exception {
		if (Driver != null){
			try{
				if(Driver.getWindowHandles() != null || Driver.getWindowHandles().isEmpty()){
					return Driver;
				}
				
			}catch(Exception e){
				return IntilizeBrowser();
			}
			
			return Driver;
		}
		else
			return IntilizeBrowser();
	}

	public static void NavigateToURL() {
		Driver.navigate().to(PropertyUtils.getConfigMessage("URL"));
		Driver.manage().window().maximize();

	}

	public static String strGetWindowTitle() {
		return Driver.getTitle();
	}

}
