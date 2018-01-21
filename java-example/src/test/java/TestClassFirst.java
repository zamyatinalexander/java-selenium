import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestClassFirst {
    private WebDriver driver;
    private WebDriverWait wait;

    public boolean isElementPresent(By locator){
        wait.until((WebDriver d) -> d.findElement(locator));
        return true;
    }

    @Before
    public void start() throws MalformedURLException, InterruptedException {
        //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("unexpectedAlertBehavior","dismiss");
        //System.setProperty("webdriver.chrome.driver", "D:\\java-selenium\\chromedriver.exe");
        //driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver.exe");
        driver = new FirefoxDriver();

        //System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        //DesiredCapabilities capability = DesiredCapabilities.chrome();
        //driver = new RemoteWebDriver(new URL("http://192.168.1.75:4444/wd/hub"),capability); //удаленный запуск
        //driver = new RemoteWebDriver(new URL("http://192.168.1.75:4444/wd/hub"),DesiredCapabilities.firefox());
        //driver.manage().window().maximize(); //c этим удаленно не работает почему-то
        driver.manage().window().setSize(new Dimension(1920, 1080));
        //System.out.println(((HasCapabilities) driver).getCapabilities());
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myTest1() throws InterruptedException {
        driver.get("https://chlist.sitechco.ru/");

        List<WebElement> email = driver.findElements(By.cssSelector("label.small-label.block"));
        WebElement email1 =  email.get(0);
        //wait.until(ExpectedConditions.stalenessOf(email));
        String em = email1.getAttribute("textContent");
        System.out.println(em);
        //Assert.assertTrue(em.equals("Пароль                                ")); //проверка




        /*((JavascriptExecutor) driver).executeScript("window.open()");
        String wind = driver.getWindowHandle();
        driver.switchTo().window(wind);
        System.out.println("id = " + wind);
        */

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


        //WebElement rows = driver.findElement(By.cssSelector("span.cnt"));
        //WebElement span = rows.findElement(By.xpath("./span/div[2]/br"));
        //String span = rows.findElements(By.xpath("./rows[1]")).getText();
        //String spana= span.getText();
        //System.out.println(spana);

        driver.findElement(By.id("search-input")).sendKeys("Чек-лист");
        driver.findElement(By.id("search-input")).sendKeys(Keys.RETURN);

    }


    //@Test
    //public void myTest2() {        driver.get("https://google.ru/");    }


    @After
    public void stop() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        driver.quit();
        driver = null;
    }
     public static void main(String[] args){
         System.out.println("qu ept");
     }
}