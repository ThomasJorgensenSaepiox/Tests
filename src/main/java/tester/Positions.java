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

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Positions {
    public static void setMypositions(List<position> somePositions) {
        mypositions = somePositions;
    }

    private static List<position> mypositions = new LinkedList<position>();

    public static void setList(List<position> alist) {
        mypositions = alist;
    }

    public static void Test(WebDriver adriver) throws InterruptedException {

        adriver.manage().window().setPosition(new Point(-1000, 0));
        adriver.manage().window().maximize();
        adriver.navigate().to(testingVariablesPile.getHost() + "#!positions-admin");
        WebDriverWait wait = new WebDriverWait(adriver, 10);


        int i = mypositions.size();
        int sizeOfDataWindow = 1;
        int local = 0;

        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + sizeOfDataWindow + "]/td[2]")));
        while ((adriver.findElements(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + sizeOfDataWindow + "]/td[2]")).size() > 0)) {
            sizeOfDataWindow++;
        }
        System.out.println(sizeOfDataWindow);

        WebElement a = adriver.findElement(By.xpath("//div[@id='Positions-Grid']/div/div/div/div[3]/div"));

        for (int j = 0; j < i; j++) {

            local = 0;
            Boolean seeker = false;
            for (int t = 0; t < i; t++) {
                local++;

                if (local == sizeOfDataWindow) {
                    a.sendKeys(Keys.PAGE_DOWN);
                    a.sendKeys(Keys.PAGE_DOWN);
                    local = 1;

                }


                if (removingDoubleQuotations(adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[3]")).getText()).equalsIgnoreCase(mypositions.get(j).getPositionId())) {
                    System.out.println("Id match, checking remaining data");
                    if (adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[2]")).getText().equalsIgnoreCase(mypositions.get(j).getPortfolioId())) {
                        System.out.println("portfolioid");
                    }

                    if (adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[4]")).getText().equalsIgnoreCase(mypositions.get(j).getPositionName())) {
                        System.out.println("position name");
                    }
                    if (adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[5]")).getText().equalsIgnoreCase(mypositions.get(j).getExposureCurrency())) {
                        System.out.println("currency");
                    }
                    if (Double.valueOf(removingDoubleQuotations(adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[7]")).getText())).equals(mypositions.get(j).getPositionNominal())){
                        System.out.println("Nominal");
                    }
                 //   System.out.println(Double.valueOf(removingDoubleQuotations(adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[8]")).getText()))+""+mypositions.get(j).getWeightedExposureValueExpCCY());
                    if (Double.valueOf(removingDoubleQuotations(adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[8]")).getText())).equals(mypositions.get(j).getWeightedExposureValueExpCCY())){
                        System.out.println("exposed");
                    }

                    if (adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[10]")).getText().equalsIgnoreCase(mypositions.get(j).getPositionGroup())) {
                        System.out.println("group");
                    }


                    if (adriver.findElement(By.xpath("//*[@id=\"Positions-Grid\"]/div/div/div/div[3]/div[3]/table/tbody/tr[" + local + "]/td[6]")).getText().equalsIgnoreCase(mypositions.get(j).getBasCurrency())) {

                        System.out.println("base");
                        // System.out.println("found on line" + t + ", full object match");

                    //    seeker = true;
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

    static public void uploadTestPositions(WebDriver adriver) {
        adriver.manage().window().setPosition(new Point(-1000, 0));
        adriver.manage().window().maximize();
        adriver.navigate().to(testingVariablesPile.getHost() + "#!positions-admin");
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.navigate().to(testingVariablesPile.getHost() + "#!positions-admin");//
        adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/span[2]/span[2]")).click();
        adriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/span[6]/span")).click();
        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"upload_3\"]/div[2]/div")));
        adriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[3]/div/div/div[1]/div[1]/div[2]/input")).sendKeys("xl test (excel_sheet)" + Keys.ENTER);
        WebElement e = adriver.findElement(By.id("upload file button"));
        e.click();
        e.sendKeys("C:\\Users\\exist\\Serenity 58 ApS\\Saepions - Documents\\SaepioX Share\\11 Test\\Data\\20191202 Positions.xlsx");

    }
}
