package tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class Dashboard {
private static String[] list1 = testingVariablesPile.getList1();
private static String[] list2 = testingVariablesPile.getList2();
private static String[] list3 = testingVariablesPile.getList3();

    public static void Test(WebDriver adriver){
        int i = list1.length;
        for (int j = 1; j < i+1; j++){
        if (adriver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+ j + "]/td[3]")).size()>0){
        WebElement acell = adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+ j + "]/td[3]"));
        if (!acell.getText().equalsIgnoreCase(list1[j-1])){
            System.out.println(acell.getText() + "is not right");

            }
        else{
            System.out.println("Successful Test");
        }}
        else{
            System.out.println("failure to find element on dashboard");
        }
            if (adriver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+ j + "]/td[4]")).size()>0){
          WebElement bcell = adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+ j + "]/td[4]"));
            if (!bcell.getText().equalsIgnoreCase(list2[j-1])){
                System.out.println(bcell.getText() + "is not right");

            }
        else{ System.out.println("Successful Test two");
        }}
            else{
                System.out.println("failure to find element on dashboard");
            }
            if (adriver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+ j + "]/td[1]")).size()>0){
            WebElement ccell = adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+ j + "]/td[1]"));
            if (!ccell.getText().equalsIgnoreCase(list3[j-1])){
                System.out.println(ccell.getText() + "is not right");

            }
            else{ System.out.println("Successful Test three");
            }}
            else{
                System.out.println("failure to find element on dashboard");
            }
        }
}
    public static void setList1(String[] aStringList){
        list1 = aStringList;
    }
    public static void setList2(String[] aStringList){
        list2 = aStringList;
    }
    public static void setList3(String[] aStringList){
        list3 = aStringList;
    }


}
