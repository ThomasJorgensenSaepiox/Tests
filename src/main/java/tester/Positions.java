package tester;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Positions {
    public static void setMypositions(List<position> somePositions) {
        mypositions = somePositions;
    }

    private static List<position> mypositions = new LinkedList<position>();

public static void setList(List<position> alist){
    mypositions = alist;
}

    public static void Test(WebDriver adriver) throws InterruptedException {

        adriver.manage().window().setPosition(new Point(-1000, 0));
        adriver.manage().window().maximize();
        adriver.navigate().to(testingVariablesPile.getHost() + "#!positions-admin");
        WebDriverWait wait = new WebDriverWait(adriver, 10);


        int i = mypositions.size();
        int sizeOfDataWindow = 1;
        int local=0;

        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr["+sizeOfDataWindow+"]/td[2]")));
        while ((adriver.findElements(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr["+sizeOfDataWindow+"]/td[2]")).size() > 0) ){
            sizeOfDataWindow++;
        }
      System.out.println(sizeOfDataWindow);

        WebElement a = adriver.findElement(By.xpath("//div[@id='Positions-Grid']/div/div/div/div[3]/div"));

        for (int j = 0; j < i; j++) {
            local++;
            if (local == sizeOfDataWindow){
                a.sendKeys(Keys.PAGE_DOWN);
                a.sendKeys(Keys.PAGE_DOWN);
            local =1;
            }
            System.out.println("local");
            System.out.println(j);


            WebElement acell = adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[3]"));
            Boolean seeker = true;

            if (!removingDoubleQuotations(acell.getText()).equalsIgnoreCase(mypositions.get(j).getPositionId())) {
                System.out.println("The id is not where expected, checking rest of page");
                seeker = false;
                int t;
                for (t = 1; t < sizeOfDataWindow; t++) {
                    if (removingDoubleQuotations(adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + t + "]/td[3]")).getText()).equalsIgnoreCase(mypositions.get(j).getPositionId())) {

                        seeker = true;
                        break;
                    }


                }
                if (!seeker) {
                    System.out.println(mypositions.get(j).getPositionId() + "could not be found on page");

                } else {
                    if (Byte.valueOf(adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + t + "]/td[2]")).getText()).equals(mypositions.get(j).getPortfolioId()) &&
                            adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + t + "]/td[4]")).getText().equalsIgnoreCase(mypositions.get(j).getPositionName())
                            && adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + t + "]/td[5]")).getText().equalsIgnoreCase(mypositions.get(j).getExposureCurrency())
                            && Double.valueOf(adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + t + "]/td[2]")).getText()).equals(mypositions.get(j).getPortfolioId())) {
                        System.out.println("found on line" + t + ", full object match");

                    }
                }
            } else {
                if (Byte.valueOf(adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[2]")).getText()).equals(mypositions.get(j).getPortfolioId()) &&
                        adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[4]")).getText().equalsIgnoreCase(mypositions.get(j).getPositionName())
                        && adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[5]")).getText().equalsIgnoreCase(mypositions.get(j).getExposureCurrency())
                        && Double.valueOf(adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[2]")).getText()).equals(mypositions.get(j).getPortfolioId())) {
                    System.out.println("found where expected, full match between position and data");
                } else {
                    System.out.println("hmm");
                }
            }
        }

    }
        private static String removingDoubleQuotations (String aNumber3){
            return aNumber3.replaceAll("\"", "").trim().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&apos;").replace(",", "");

        }


    }
