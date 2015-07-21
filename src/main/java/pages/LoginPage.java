package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "gmail-sign-in")
    private WebElement signIn;

    @FindBy(id = "signIn")
    private WebElement signInButton;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Passwd")
    private WebElement passwordField;

    @FindBy(id = "next")
    private WebElement nextButton;


    public GmailPage login (String user, String password){
        if (driver.getCurrentUrl().endsWith("/about.html"))
            signIn.click();
        inputEmail(user);
        inputPassword(password);
        return new GmailPage(driver);
    }

    private void inputEmail(String email) {
        emailField.sendKeys(email);
        nextButton.click();
    }

    private void inputPassword(String password) {
        passwordField.sendKeys(password);
        signInButton.click();
    }
}
