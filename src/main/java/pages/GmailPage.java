package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPage extends BasePage{

    public GmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "next")
    private WebElement nextButton;

    @FindBy(xpath = "//*[@id='gbwa']/following::a[2]")
    private WebElement accountButton;

    @FindBy(css = "a[href^=\"https://mail.google.com/mail/logout\"]")
    private WebElement logOutButton;

    @FindBy(xpath = "//div[@id=\"gbwa\"]/div[1]/a")
    private WebElement appsButton;

    @FindBy(id = "gb49")
    private WebElement driveButton;


    public String getCurrentUser() {
        return accountButton.getAttribute("title");
    }

    public void goToDrive(){
        appsButton.click();
        driveButton.click();
    }

    public LoginPage logOut() {
        accountButton.click();
        logOutButton.click();
        return new LoginPage(driver);
    }

}
