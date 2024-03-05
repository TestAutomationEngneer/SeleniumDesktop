import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class Desktop2Test {


    public DesktopOptions options;
    public WiniumDriver driver;

    //1. włączyć w windows Tryb developera
    //2. Włączyć driver double click w lokalizacji C:\Users\hryci\Desktop\selenium\Winium.Desktop.Driver
    //3. Zainstalować Windows SDK 10
    //4 Uzyc inspect C:\Program Files (x86)\Windows Kits\10\bin\10.0.22621.0\x86
    @BeforeEach
    public void SetUp() throws MalformedURLException {
        options = new DesktopOptions();
        options.setApplicationPath("C:\\Windows\\System32\\calc.exe");


        driver = new WiniumDriver(new URL("http://localhost:9999"), options);


    }

    @Test
    public void testCalculator() throws InterruptedException, MalformedURLException {

        Thread.sleep(3000);
        WebElement window =  driver.findElementByClassName("CalcFrame");
//        WebElement menuItem = window.findElement(By.id("MenuBar")).findElement(By.name("View"));
//        menuItem.click();
//        driver.findElementByName("Scientific").click();
//
//        window.findElement(By.id("MenuBar")).findElement(By.name("View")).click();
//        driver.findElementByName("History").click();
//
//        window.findElement(By.id("MenuBar")).findElement(By.name("View")).click();
//        driver.findElementByName("History").click();
//
        window.findElement(By.id("MenuBar")).findElement(By.name("View")).click();
        driver.findElementByName("Standard").click();

//        driver.findElementByName("4").click();
//        driver.findElementByName("Add").click();
//        driver.findElementByName("5").click();
//        driver.findElementByName("Equals").click();

        String result = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
        System.out.println("Result is: " + result);
        assertThat(result).isEqualTo("16");

        driver.findElement(By.name("Close")).click();

        driver.close();
    }
}