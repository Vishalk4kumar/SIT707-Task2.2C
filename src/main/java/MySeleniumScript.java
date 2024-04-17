import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

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

		// Fill values in target elements
		WebElement firstNameInput = driver.findElement(By.id("firstname"));
		firstNameInput.sendKeys("Vish");

		WebElement lastNameInput = driver.findElement(By.id("lastname"));
		lastNameInput.sendKeys("Kum");

		WebElement emailInput = driver.findElement(By.id("email"));
		emailInput.sendKeys("my_email@example.com");

		WebElement phoneInput = driver.findElement(By.id("phoneNumber"));
		phoneInput.sendKeys("0423160160");

		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys("Password@1");

		WebElement confirmPasswordInput = driver.findElement(By.id("confirmPassword"));
		confirmPasswordInput.sendKeys("Password@1");

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
