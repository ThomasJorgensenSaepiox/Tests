import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tester.Agreement;
import tester.Session;
import tester.TheMasterVariables;
import tester.User;

import java.util.Optional;

public class TestAgreementStuff {
    private static  WebDriver driver;


    @Test
    public void testCreate() throws InterruptedException {
        TheMasterVariables variables = new TheMasterVariables("http://www.localhost:5000/", "tj@saepiox.com", "pass", "FireFox", "Charles Ponzi",
                "ASSET_MANAGER", Optional.of("C:\\Tests\\FileUpload1.exe"), Optional.of("C:\\Tests\\FileUpload2.exe"), Optional.of("anEmail@mail.com"),
                Optional.of("@TerriblePass1"), Optional.of("Bad User"), "C:\\screenshots\\");
        Session session = new Session();

        WebDriver driver = new FirefoxDriver();
        session.admin(driver, variables);
        Agreement agreement = new Agreement();
        agreement.Navigate_to_Agreement(driver,variables);
        
    }


}
