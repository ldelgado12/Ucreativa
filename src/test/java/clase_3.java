import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.asserts.*;



public class clase_3 {

    private WebDriver driver;

    @Parameters({"username", "password"})
    @Test
    public void user_login (String username, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/Resources/driver/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/index.php?route=account/login");

        WebElement emailTextBox = driver.findElement(By.id("input-email"));
        WebElement passwordTextBox = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));

        emailTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        loginButton.click();

        Thread.sleep(3000);

        WebElement dashboard = driver.findElement(By.id("account-account"));

        Assert.assertEquals(dashboard.isDisplayed(), true);

        driver.quit();

    }


}
