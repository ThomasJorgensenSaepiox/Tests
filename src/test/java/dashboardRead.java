import org.junit.Before;
import org.openqa.selenium.WebDriver;
import tester.*;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import tester.theVariables;
import tester.User;
public class dashboardRead {
    private static WebDriver driver;

    @Before
    public void setup() {


        theVariables.setAdminPass("pass");
        theVariables.setAdminlogin("rg@saepiox.com");
    }
    @Test
    public void testingDefaultDash(){
        driver = new ChromeDriver();
        Session.admin(driver);
/*//this is some trash to verify the logic of the test - with an actually functional import, these will be set by code. 3 first entries match current database, last 2 are wrong.
        testingVariablesPile.setList1(new String[]{"-2,049,927","2,834,430","93,439,123","500,963,338" ,"511,304" ,"2,616,409"});
        testingVariablesPile.setList2(new String[]{"aud","gbp","usd","jpy" ,"cad" ,"gbp"});
        testingVariablesPile.setList3(new String[]{"Sub Portfolio 1","Sub Portfolio 1","Sub Portfolio 1","Sub Portfolio 1" ,"Sub Portfolio 2" ,"Sub Portfolio 2"});
        Dashboard.Test(driver);
  */
    }
    @Test
    public void testingCharlesDash(){
        Session.admin(driver);
        User.auser(driver);

    }
public void teardown(){
        driver.close();
}

}
