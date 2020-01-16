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

public class Position_history {
    public void Navigate_to_position_history(WebDriver adriver, SessionVariables variables) {
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.navigate().to(variables.getHost() + "#!position-change-view-new");
        wait.until(presenceOfElementLocated(By.id("PositionChange_Charts")));
    }

    public void take_screenshot_position_history(WebDriver adriver, ScreenshotVariables variables) {
        File screenshot = ((TakesScreenshot) adriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(variables.getScreenSaveLocation() + variables.getWebBrowser() + "_tradesheet.jpg"));
        } catch (IOException e) {

        }
    }
}
