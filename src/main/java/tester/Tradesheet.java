package tester;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Tradesheet {
public void Navigate_to_Tradesheet(WebDriver adriver, TheMasterVariables variables) {
    WebDriverWait wait = new WebDriverWait(adriver, 10);
    adriver.navigate().to(variables.getHost() + "#!trade-sheet");
    wait.until(presenceOfElementLocated(By.id("tradesheet")));
}

public void take_screenshot_tradesheet(WebDriver adriver, ScreenshotVariables variables){
    File screenshot = ((TakesScreenshot)adriver).getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(screenshot, new File("C:\\screenshots\\"+ variables.getWebBrowser() +"_tradesheet.jpg"));
    }
    catch (IOException e){

    }

}
}
