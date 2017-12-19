import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestClassFirst {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){

        //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("unexpectedAlertBehavior","dismiss");
        //driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver = new RemoteWebDriver(DesiredCapabilities.firefox());
        driver.manage().window().maximize();
        //System.out.println(((HasCapabilities) driver).getCapabilities());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myTest1() throws InterruptedException {
        driver.get("https://chlist.sitechco.ru/");
        //driver.findElement(By.name("user_auth[email]")).sendKeys("zamyatinrussia@mail.ru");
        //driver.findElement(By.cssSelector("[id=user_auth_email]")).sendKeys("zamyatinrussia@mail.ru");
        driver.findElement(By.xpath("//*[@name='user_auth[email]']")).sendKeys("zamyatinrussia@mail.ru");
        driver.findElement(By.name("user_auth[password]")).sendKeys("123456");
        TimeUnit.SECONDS.sleep(1);
        //driver.findElement(By.className("btn blue")).click();
        driver.findElement(By.cssSelector("input.btn.blue")).click();
        //wait.until(titleIs("afsd"));
        driver.findElement(By.xpath("//a[contains(.,'Чек-лист 2')]"));
        TimeUnit.SECONDS.sleep(1);


        WebElement rows = driver.findElement(By.cssSelector("span.cnt"));
        //WebElement span = rows.findElement(By.xpath("./span/div[2]/br"));
        //String span = rows.findElements(By.xpath("./rows[1]")).getText();
        //String spana= span.getText();
        //System.out.println(spana);

        driver.findElement(By.id("search-input")).sendKeys("Чек-лист");
        driver.findElement(By.id("search-input")).sendKeys(Keys.RETURN);
    }


    @Test
    public void myTest2() {
        driver.get("https://google.ru/");
    }






    @After
    public void stop() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        driver.quit();
        driver = null;
    }
}