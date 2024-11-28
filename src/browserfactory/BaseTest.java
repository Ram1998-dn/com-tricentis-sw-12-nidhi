package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    // Method to initialize the browser
    public void openBrowser(String baseUrl) {

        // Initialize WebDriver
        System.setProperty("webDriver.chrome.driver", "C:\\Soft\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }

    public void closerBrowser() {
        // Method to close the browser (method closes all browser windows and ends the WebDriver session)
        driver.quit();
    }
}
