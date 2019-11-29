package tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class Dashboard {
    public void setMypositions(List<position> somePositions) {
        mypositions = somePositions;
    }

    private static List<position> mypositions = new LinkedList<position>();

    public static void Test(WebDriver adriver) {
        int i = mypositions.size();
        for (int j = 1; j < i + 1; j++) {
            if (adriver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + j + "]/td[3]")).size() > 0) {

                WebElement acell = adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + j + "]/td[3]"));
                Boolean seeker = true;
                if (!acell.getText().equalsIgnoreCase(mypositions.get(j - 1).getPositionNominal().toString())) {
                    System.out.println("The id is not where expected, checking rest of page");
                    seeker = false;
                    int t;
                    for (t = 1; t < i + 1; t++) {
                        if (adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + t + "]/td[3]")).getText().equalsIgnoreCase(mypositions.get(j - 1).getPositionNominal().toString())) {
                            seeker = true;
                            break;
                        }


                    }
                    if (!seeker) {
                        System.out.println(mypositions.get(j - 1).getPositionNominal() + "could not be found on page");

                    } else {
                        if (adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + t + "]/td[3]")).getText().equalsIgnoreCase(mypositions.get(j - 1).getPositionNominal().toString()) &&
                                adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + t + "]/td[5]")).getText().equalsIgnoreCase(mypositions.get(j - 1).getExposureRatio().toString()) &&
                                adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + t + "]/td[1]")).getText().equalsIgnoreCase(mypositions.get(j - 1).getPriceDate())
                                && adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + t + "]/td[4]")).getText().equalsIgnoreCase(mypositions.get(j - 1).getExposureCurrency())
                                && adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + t + "]/td[2]")).getText().equalsIgnoreCase(String.valueOf(mypositions.get(j - 1).getPortfolioId()))) {
                            System.out.println("found on line" + t + ", full object match");

                        }
                    }
                } else {
                    if (adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + j + "]/td[3]")).getText().equalsIgnoreCase(mypositions.get(j - 1).getPositionNominal().toString()) &&
                            adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + j + "]/td[5]")).getText().equalsIgnoreCase(mypositions.get(j - 1).getExposureRatio().toString()) &&
                            adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + j + "]/td[1]")).getText().equalsIgnoreCase(mypositions.get(j - 1).getPriceDate())
                            && adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + j + "]/td[4]")).getText().equalsIgnoreCase(mypositions.get(j - 1).getExposureCurrency())
                            && adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr[" + j + "]/td[2]")).getText().equalsIgnoreCase(String.valueOf(mypositions.get(j - 1).getPortfolioId()))) {
                        System.out.println("Match found, in expected place.");
                    }
                }
            }
        }
    }
}