package tester;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class portfolios {
    public static void Navigate_to_portfolio(WebDriver adriver) {
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.navigate().to(testingVariablesPile.getHost() + "#!portfolio-admin");
        wait.until(presenceOfElementLocated(By.id("listParent")));
    }

    public static void take_screenshot_portfolio(WebDriver adriver){
        File screenshot = ((TakesScreenshot)adriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\screenshots\\"+ testingVariablesPile.getWebbrowser() +"_portfolio.jpg"));
        }
        catch (IOException e){

        }}
    static public void uploadTestPortfolios(WebDriver adriver) {
        adriver.manage().window().setPosition(new Point(-1000, 0));
        adriver.manage().window().maximize();
        adriver.navigate().to(testingVariablesPile.getHost() + "#!portfolio-admin");
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"topbar\"]/div/div[2]/div/span")));
        adriver.findElement(By.xpath("//*[@id=\"topbar\"]/div/div[2]/div/span")).click();
        adriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/span[3]/span")).click();

        wait.until(presenceOfElementLocated(By.id("selectFileButton")));

        WebElement e = adriver.findElement(By.id("selectFileButton"));
        e.click();

        try {
            Runtime.getRuntime().exec("C:\\Tests\\FileUpload2.exe");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        e = adriver.findElement(By.id("importButton"));
        wait.until(ExpectedConditions.textToBePresentInElement(adriver.findElement(By.id("processResult")), "Data successfully processed and ready to import"));
        e.click();

    }

}
