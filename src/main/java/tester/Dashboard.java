package tester;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Dashboard {
    public static void Navigate_to_Dashboard(WebDriver adriver) {
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.navigate().to(testingVariablesPile.getHost() + "#!dashboard");
        wait.until(presenceOfElementLocated(By.id("dashboard-grid")));
    }

    public static void take_screenshot_dashboard(WebDriver adriver){
        File screenshot = ((TakesScreenshot)adriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\screenshots\\"+ testingVariablesPile.getWebbrowser() +"_dashboard.jpg"));
        }
        catch (IOException e){

        }}
    public static void setMypositions(List<position> somePositions) {
        mypositions = somePositions;
    }

    private static List<position> mypositions = new LinkedList<position>();

    public static void Test(WebDriver adriver) {
        adriver.manage().window().setPosition(new Point(-1000,0));
        adriver.manage().window().maximize();


        int i = mypositions.size();
        if (i>10){
            i=10;
        }
        for (int j = 1; j < i + 1; j++) {
            System.out.println(j);
            if (adriver.findElements(By.xpath("//*[@id=\"dashboard-grid\"]/div[3]/table/tbody/tr["+j+"]/td[3]")).size() > 0) {

                WebElement acell = adriver.findElement(By.xpath("//*[@id=\"dashboard-grid\"]/div[3]/table/tbody/tr["+j+"]/td[3]"));
                Boolean seeker = true;

                if (!Double.valueOf(removingDoubleQuotations(acell.getText())).equals(mypositions.get(j - 1).getPositionNominal())) {
                    System.out.println("The id is not where expected, checking rest of page");
                    seeker = false;
                    int t;
                    for (t = 1; t < i + 1; t++) {
                        if (Double.valueOf(removingDoubleQuotations(adriver.findElement(By.xpath("//*[@id=\"dashboard-grid\"]/div[3]/table/tbody/tr[" + t + "]/td[3]")).getText())).equals(mypositions.get(j - 1).getPositionNominal())){

                            seeker = true;
                            break;
                        }


                    }
                    if (!seeker) {
                        System.out.println(mypositions.get(j - 1).getPositionNominal() + "could not be found on page");

                    } else {
                        if (Byte.valueOf(adriver.findElement(By.xpath("//*[@id=\"dashboard-grid\"]/div[3]/table/tbody/tr[" + t + "]/td[5]")).getText()).equals(mypositions.get(j - 1).getExposureRatio()) &&
                                adriver.findElement(By.xpath("//*[@id=\"dashboard-grid\"]/div[3]/table/tbody/tr[" + t + "]/td[1]")).getText().equalsIgnoreCase(mypositions.get(j - 1).getPriceDate())
                                && adriver.findElement(By.xpath("//*[@id=\"dashboard-grid\"]/div[3]/table/tbody/tr[" + t + "]/td[4]")).getText().equalsIgnoreCase(mypositions.get(j - 1).getExposureCurrency())
                                && Double.valueOf(adriver.findElement(By.xpath("//*[@id=\"dashboard-grid\"]/div[3]/table/tbody/tr[" + t + "]/td[2]")).getText()).equals(mypositions.get(j - 1).getPortfolioId())) {
                            System.out.println("found on line" + t + ", full object match");

                        }
                    }
                } else { if(adriver.findElement(By.xpath("//*[@id=\"dashboard-grid\"]/div[3]/table/tbody/tr[" + j + "]/td[1]")).getText().equalsIgnoreCase(mypositions.get(j - 1).getName())&&
                        adriver.findElement(By.xpath("//*[@id=\"dashboard-grid\"]/div[3]/table/tbody/tr[" + j + "]/td[4]")).getText().equalsIgnoreCase(mypositions.get(j - 1).getExposureCurrency())&&
                        Double.valueOf(adriver.findElement(By.xpath("//*[@id=\"dashboard-grid\"]/div[3]/table/tbody/tr[" + j + "]/td[2]")).getText()).equals(mypositions.get(j - 1).getPortfolioId())) {
                        System.out.println(j+"th line verifed");
                    }
                }
            }
        }
    }

    private static String removingDoubleQuotations(String aNumber3) {
        return aNumber3.replaceAll("\"", "").trim().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&apos;").replace(",", "");

    }
}