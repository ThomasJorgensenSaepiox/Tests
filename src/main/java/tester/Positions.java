package tester;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Positions {
    public void Navigate_to_positions(WebDriver adriver, PositionVariables aVariables) {
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.navigate().to(aVariables.getHost() + "#!positions-admin");
     wait.until(presenceOfElementLocated(By.id("positions_table")));
    }

    public void take_screenshot_positions(WebDriver adriver, ScreenshotVariables variables){
        File screenshot = ((TakesScreenshot)adriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(variables.getScreenSaveLocation()+ variables.getWebBrowser() +"_portfolio.jpg"));
        }
        catch (IOException e){

        }}
    public void setMypositions(List<position> somePositions) {
        mypositions = somePositions;
    }

    private List<position> mypositions = new LinkedList<position>();

    public void setList(List<position> alist) {
        mypositions = alist;
    }

    public void Test(WebDriver adriver, PositionVariables variables) throws InterruptedException {

        adriver.manage().window().setPosition(new Point(-1000, 0));
        adriver.manage().window().maximize();

        adriver.navigate().to(new StringBuilder().append(variables.getHost()).append("#!positions-admin").toString());
        WebDriverWait wait = new WebDriverWait(adriver, 10);


        int i = mypositions.size();
        int sizeOfDataWindow = 1;
        int local = 0;

        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + sizeOfDataWindow + "]/td[2]")));
        while ((adriver.findElements(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + sizeOfDataWindow + "]/td[2]")).size() > 0)) {
            sizeOfDataWindow++;
        }
        System.out.println(sizeOfDataWindow);

        WebElement a = adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[1]"));

        for (int j = 0; j < i; j++) {

            local = 0;
            Boolean seeker = false;
            for (int t = 0; t < i; t++) {
                local++;

                if (local == sizeOfDataWindow) {
                    a.sendKeys(Keys.PAGE_DOWN);

                    local = 1;

                }


                if (removingDoubleQuotations(adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[3]")).getText()).equalsIgnoreCase(mypositions.get(j).getPositionId())) {

                    if (adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[2]")).getText().equalsIgnoreCase(mypositions.get(j).getPortfolioId()) &&
                      //      adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[4]")).getText().equalsIgnoreCase(mypositions.get(j).getPositionName()) &&
                        //    adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[5]")).getText().equalsIgnoreCase(mypositions.get(j).getExposureCurrency()) &&
                      //      Double.valueOf(removingDoubleQuotations(adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[7]")).getText())).equals(Double.valueOf(mypositions.get(j).getWeightedExposureValueExpCCY())) &&
                    //        Double.valueOf(removingDoubleQuotations(adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[8]")).getText())).equals(Double.valueOf(removingDoubleQuotations(mypositions.get(j).getExpBas()))) &&
                    //        adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[10]")).getText().equalsIgnoreCase(mypositions.get(j).getPositionGroup()) &&
                            adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[6]")).getText().equalsIgnoreCase(mypositions.get(j).getBasCurrency())) {
                        System.out.println("found on line" + t + ", full object match");
                        seeker = true;
                        break;
                    }

                }


            }

            if (!seeker) {
                System.out.println(mypositions.get(j).getPositionId() + "could not be found on page");
            }
            for (int y = 0; y < i / sizeOfDataWindow; y++) {
                a.sendKeys(Keys.PAGE_UP);
                a.sendKeys(Keys.PAGE_UP);

            }
        }


    }

    private static String removingDoubleQuotations(String aNumber3) {
        return aNumber3.replaceAll("\"", "").trim().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&apos;").replace(",", "");

    }

    static void uploadTestPositions(WebDriver adriver, PositionVariables variables) {
        adriver.manage().window().setPosition(new Point(-1000, 0));
        adriver.manage().window().maximize();
        adriver.navigate().to(variables.getHost() + "#!positions-admin");
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[2]/div/span")));
        adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[2]/div/span")).click();
        adriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/span[2]/span")).click();

        wait.until(presenceOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div/div[3]/div/div/div[1]/div/div[2]/input")));
           adriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[3]/div/div/div[1]/div/div[2]/input")).sendKeys("xl test (Excel)" + Keys.ENTER + Keys.ENTER);
        WebElement e = adriver.findElement(By.id("selectFileButton"));
        e.click();

        try {
            Runtime.getRuntime().exec(variables.getImportPositionsScript().orElse("C:\\Tests\\FileUpload.exe"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        e = adriver.findElement(By.id("importButton"));
        wait.until(ExpectedConditions.textToBePresentInElement(adriver.findElement(By.id("processResult")), "Data successfully processed and ready to import"));
        e.click();

    }


}

