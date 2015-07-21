package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import java.util.List;

public class DrivePage extends BasePage{

    public DrivePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@guidedhelpid=\"new_menu_button\"]")
    private WebElement newButton;

    @FindBy(xpath = "//div[@role=\"menu\"]/div[1]")
    private WebElement folderButton;

    @FindBy(xpath = "//div[@role=\"dialog\"][last()]//input")
    private WebElement folderNameInput;

    @FindBy(xpath = "//div[@role=\"dialog\"][last()]//button[@name=\"ok\"]")
    private WebElement createButton;

    @FindBy(xpath = "//div[@guidedhelpid=\"drive_homepage_toolbar\"]/div/div[4]")
    private WebElement removeButton;

    @FindBy(xpath = "//div[@data-target=\"itemUploadDrop\"]")
    private List<WebElement> folders;


    public void createFolder(String name) {
        newButton.click();
        folderButton.click();
        folderNameInput.sendKeys(name);
        createButton.click();
    }

    public int getSpecificFoldersCount(String folderName) {
        int count = 0;
        for (int i = 0; i < folders.size(); i++)
            if (folders.get(i).getText().equals(folderName)) count++;
        return count;
    }

    public void removeSpecificFolders(ITestResult result, String folderName) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            for(WebElement folder : folders) {
                if (folder.getText().equals(folderName)) {
                    removeElement(folder);
                }
            }
        }
    }

    private void removeElement(WebElement item) {
        item.click();
        removeButton.click();
    }
}
