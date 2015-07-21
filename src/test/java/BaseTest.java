import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.GmailPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver driver;
    protected GmailPage mpage;

    protected String user;
    protected String password;

    @Parameters({ "user", "password" })
    @BeforeMethod
    public void initCredentials(String userName, String password){
        this.user = userName;
        this.password = password;
    }

    @BeforeMethod
    public void setupSelenium(){
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://www.gmail.com");

        LoginPage lpage = new LoginPage(driver);
        mpage = lpage.login(user, password);
    }

    @AfterMethod
    public void closeSelenium(){
        driver.quit();
    }
}
