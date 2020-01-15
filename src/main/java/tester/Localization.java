package tester;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Localization {
    public void Navigate_to_localization(WebDriver adriver, SessionVariables variables) {
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.navigate().to(variables.getHost() + "#!localized-text");
        wait.until(presenceOfElementLocated(By.id("localization_list")));
    }

    public void take_screenshot_tradesheet(WebDriver adriver, ScreenshotVariables variables){
        File screenshot = ((TakesScreenshot)adriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(variables.getScreenSaveLocation()+ variables.getWebBrowser() +"_localization.jpg"));
        }
        catch (IOException e){

        }

    }

}
