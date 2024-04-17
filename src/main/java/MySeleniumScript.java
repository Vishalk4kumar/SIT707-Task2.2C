import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.io.File;
import java.io.IOException;

public class MySeleniumScript {

	public static void main(String[] args) {
		// Set Chrome driver path
		System.setProperty("webdriver.chrome.driver",
				"D:\\Downloads New\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

		// Set Chrome options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // Maximize window

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver(options);

		// Navigate to officeworks registration page
		driver.get(
				"https://www.officeworks.com.au/app/identity/create-account?redirect_path=%2Fapp%2Fcatalogue%2Flogin-redirect%3Fcomponent_id%3DODP-login-button%26entry_point%3D%2F");

		// Fill values in target elements using relative locators

		
        WebElement firstName = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.id("lastname")));
        firstName.sendKeys("Vishal");

        WebElement lastName = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("firstname")));
        lastName.sendKeys("Kumar");

        WebElement email = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("phoneNumber")));
        email.sendKeys("my_email@example.com");

        WebElement phone = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("lastname")));
        phone.sendKeys("0423160160");

        WebElement password = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("email")));
        password.sendKeys("Password@1");

        WebElement confirmPassword = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("password")));
        confirmPassword.sendKeys("Password@1");

		// Identify Create account button and click
		WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
		createAccountButton.click();

		// Wait for page to load after clicking Create account button
		try {
			Thread.sleep(5000); // Wait for 5 seconds (adjust as needed)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Capture screenshot
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = "officeworks_registration_page_screenshot.png";

		try {
			// Save the screenshot to a file
			FileHandler.copy(screenshotFile, new File(screenshotPath));
			System.out.println("Screenshot saved successfully: " + screenshotPath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Close browser
		driver.quit();
	}
}
