import org.testng.Assert;
import org.testng.annotations.Test;

public class GmailTest extends BaseTest{

    @Test
    public void testLogIn(){
        Assert.assertTrue(driver.getCurrentUrl().startsWith("https://mail.google.com/mail/"), "Wrong URL");
        Assert.assertTrue(mpage.getCurrentUser().contains(user), "LogIn failed");
    }

    @Test
    public void testLogOut(){
        mpage.logOut();
        Assert.assertTrue(driver.getCurrentUrl().startsWith("https://accounts.google.com/ServiceLogin"), "LogOut failed!");
    }
}
