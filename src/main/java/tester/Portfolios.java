package tester;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Portfolios {
    public void Navigate_to_portfolio(WebDriver adriver, PortfolioVariables variables) {
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.navigate().to(variables.getHost() + "#!portfolio-admin");
        wait.until(presenceOfElementLocated(By.id("listParent")));
    }

    public void take_screenshot_portfolio(WebDriver adriver,ScreenshotVariables variables){
        File screenshot = ((TakesScreenshot)adriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(variables.getScreenSaveLocation()+ variables.getWebBrowser() +"_portfolio.jpg"));
        }
        catch (IOException e){

        }}
     public void uploadTestPortfolios(WebDriver adriver, PortfolioVariables variables) {
        adriver.manage().window().setPosition(new Point(-1000, 0));
        adriver.manage().window().maximize();
        adriver.navigate().to(variables.getHost() + "#!portfolio-admin");
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"topbar\"]/div/div[2]/div/span")));
        adriver.findElement(By.xpath("//*[@id=\"topbar\"]/div/div[2]/div/span")).click();
        adriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/span[3]/span")).click();

        wait.until(presenceOfElementLocated(By.id("selectFileButton")));

        WebElement e = adriver.findElement(By.id("selectFileButton"));
        e.click();

        try {
            Runtime.getRuntime().exec(variables.getImportPortfoliosScript().orElse("C:\\Tests\\FileUpload2.exe"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        e = adriver.findElement(By.id("importButton"));
        wait.until(ExpectedConditions.textToBePresentInElement(adriver.findElement(By.id("processResult")), "Data successfully processed and ready to import"));
        e.click();

    }

}
