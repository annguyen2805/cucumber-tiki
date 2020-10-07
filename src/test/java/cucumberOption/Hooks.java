package cucumberOption;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	private static WebDriver driver;

	public synchronized static WebDriver openAndQuitBrowser() {
		String browser = System.getProperty("BROWSER");
		System.out.println("Browser name run by command line = " + browser);

		if (driver == null) {

			try {
				if (browser == null) {
					browser = System.getenv("BROWSER");
					if (browser == null) {
						browser = "chrome";
					}
				}

				switch (browser) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "hchrome":
					WebDriverManager.chromedriver().setup();
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("headless");
					chromeOptions.addArguments("window-size=1920x1080");
					driver = new ChromeDriver(chromeOptions);
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
					System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
					driver = new FirefoxDriver();
					break;
				default:
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				}
			} 
			finally {
				Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
			}

			driver.get("https://tiki.vn/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		return driver;
	}

	public static void close() {
		try {
			if (driver != null) {
				openAndQuitBrowser().quit();
			}
		} catch (UnreachableBrowserException e) {
			System.out.println("Can not close the browser");
		}
	}

	private static class BrowserCleanup implements Runnable {
		@Override
		public void run() {
			close();
		}
	}

}
