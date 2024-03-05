import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import static org.assertj.core.api.Assertions.assertThat;

public class DesktopTest {


    public DesktopOptions options = new DesktopOptions();

    @BeforeEach
    public void SetUp() {
        options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
    }

    @Test
    public void testCalculator() throws InterruptedException, MalformedURLException {
        WiniumDriver driver = null;
        String appPath = "C:/windows/system32/calc.exe";
        DesktopOptions option = new DesktopOptions();
        option.setApplicationPath(appPath);
        option.setDebugConnectToRunningApp(false);
        option.setLaunchDelay(2);
        driver = new WiniumDriver(new URL("http://localhost:9999"), option);
        Thread.sleep(3000);
        driver.findElement(By.id("num8Button")).click();
        driver.findElement(By.id("plusButton")).click();
        driver.findElement(By.id("num8Button")).click();
        driver.findElement(By.id("equalButton")).click();
        Thread.sleep(2000);

        String result = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
        System.out.println("Result is: " + result);
        assertThat(result).isEqualTo("16");

        driver.findElement(By.name("Close")).click();

        driver.close();
    }
}