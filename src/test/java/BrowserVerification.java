import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import tester.*;

import java.util.Optional;

public class BrowserVerification {

    private void generic_test(WebDriver adriver, TheMasterVariables aVar){
        Agreement agreement = new Agreement();
        agreement.Navigate_to_Agreement(adriver, aVar);
        agreement.take_screenshot_agreement(adriver, aVar);
        Csa csa = new Csa();
        csa.Navigate_to_csa(adriver, aVar);
        csa.take_screenshot_csa(adriver, aVar);
        Dashboard dashboard = new Dashboard();
        dashboard.Navigate_to_Dashboard(adriver, aVar);
        dashboard.take_screenshot_dashboard(adriver, aVar);
        Limits limits = new Limits();
        limits.Navigate_to_Limits(adriver, aVar);
        limits.take_screenshot_limits(adriver, aVar);
        Limits_history limits_history = new Limits_history();
        limits_history.Navigate_to_Limit_history(adriver, aVar);
        limits_history.take_screenshot_limit_history(adriver, aVar);
        Localization localization = new Localization();
        localization.Navigate_to_localization(adriver, aVar);
        localization.take_screenshot_tradesheet(adriver,aVar);
        Portfolios portfolios = new Portfolios();
        portfolios.Navigate_to_portfolio(adriver, aVar);
        portfolios.take_screenshot_portfolio(adriver, aVar);
        Position_history position_history = new Position_history();
        position_history.Navigate_to_position_history(adriver, aVar);
        position_history.take_screenshot_position_history(adriver, aVar);
        Positions positions = new Positions();
        positions.Navigate_to_positions(adriver, aVar);
        positions.take_screenshot_positions(adriver, aVar);
        Trade trade = new Trade();
        trade.Navigate_to_Trade(adriver, aVar);
        trade.take_screenshot_trades(adriver, aVar);
        Tradehistory tradehistory = new Tradehistory();
        tradehistory.Navigate_to_Trade(adriver, aVar);
        tradehistory.take_screenshot_trades(adriver, aVar);
        Tradesheet tradesheet = new Tradesheet();
        tradesheet.Navigate_to_Tradesheet(adriver, aVar);
        tradesheet.take_screenshot_tradesheet(adriver, aVar);
        User user = new User();
        user.Navigate_to_user(adriver, aVar);
        user.take_screenshot_user(adriver, aVar);
        UserSettings userSettings = new UserSettings();
        userSettings.Navigate_to_user_settings(adriver, aVar);
        userSettings.take_screenshot_user_settings(adriver, aVar);
        Xray xray = new Xray();
        xray.Navigate_to_x_ray(adriver, aVar);
        xray.take_screenshot_xray(adriver, aVar);
    }
@Test
    public void Chrome() {
        TheMasterVariables variables = new TheMasterVariables("http://www.localhost:5000/","tj@saepiox.com","pass","chrome","Charles Ponzi",
                "ASSET_MANAGER", Optional.of("C:\\Tests\\FileUpload1.exe"),Optional.of("C:\\Tests\\FileUpload2.exe"),Optional.of("anEmail@mail.com"),
                Optional.of("@TerriblePass1"),Optional.of("Bad User"),"C:\\screenshots\\");
        Session session = new Session();

        WebDriver driver = new FirefoxDriver();
        session.admin(driver, variables);
        generic_test(driver, variables);
    }
@Test
    public void Firefox() {
        TheMasterVariables variables = new TheMasterVariables("http://www.localhost:5000/","tj@saepiox.com","pass","FireFox","Charles Ponzi",
                "ASSET_MANAGER", Optional.of("C:\\Tests\\FileUpload1.exe"),Optional.of("C:\\Tests\\FileUpload2.exe"),Optional.of("anEmail@mail.com"),
                Optional.of("@TerriblePass1"),Optional.of("Bad User"),"C:\\screenshots\\");
    Session session = new Session();

    WebDriver driver = new FirefoxDriver();
    session.admin(driver, variables);
        generic_test(driver, variables);
    }
    @Test
    public void IE() {
        TheMasterVariables variables = new TheMasterVariables("http://www.localhost:5000/","tj@saepiox.com","pass","IE","Charles Ponzi",
                "ASSET_MANAGER", Optional.of("C:\\Tests\\FileUpload1.exe"),Optional.of("C:\\Tests\\FileUpload2.exe"),Optional.of("anEmail@mail.com"),
                Optional.of("@TerriblePass1"),Optional.of("Bad User"),"C:\\screenshots\\");
        Session session = new Session();

        WebDriver driver = new InternetExplorerDriver();
        session.admin(driver, variables);
        generic_test(driver, variables);
    }
}