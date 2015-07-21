import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import pages.DrivePage;

public class DriveTest extends BaseTest{

    private DrivePage dpage;
    private String folderName = "Drive Test Folder";

        @BeforeMethod
        public void openDrivePage() {
            mpage.goToDrive();
            dpage = (DrivePage)mpage.switchTab(1,DrivePage.class);
        }

        @Test
        public void testDrive(){
            dpage.createFolder(folderName);
            Assert.assertEquals(dpage.getSpecificFoldersCount(folderName), 1, "Count of folders with name " + folderName + "is incorrect!");
        }

        @AfterMethod
        public void removeFolder(){
            dpage.removeSpecificFolders(Reporter.getCurrentTestResult(), folderName);
        }
}
