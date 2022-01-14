package HomeWork17;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SecondTest {

    WebDriver secondDriver;

    @BeforeClass
    public void driverInit() {
        secondDriver = BaseTest.driverInit();
    }

    @Test
    public void webSiteCheck1() {
        secondDriver.get("https://www.portmone.com.ua/");
        Assert.assertTrue(secondDriver.getTitle().contains("Платіжна система Portmone.com"), "This page does not contains 'Платіжна система Portmone.com'");
    }

    @Test
    public void webSiteCheck2() {
        secondDriver.navigate().to("https://www.portmone.com.ua/catalog");
        secondDriver.navigate().refresh();
        Assert.assertEquals("https://www.portmone.com.ua/catalog", secondDriver.getCurrentUrl());
    }

    @Test
    public void webSiteCheck3(){
        secondDriver.navigate().back();
        Assert.assertEquals("https://www.portmone.com.ua/", secondDriver.getCurrentUrl());
        secondDriver.navigate().forward();
        Assert.assertEquals("https://www.portmone.com.ua/catalog", secondDriver.getCurrentUrl());
    }

    @AfterClass
    public void webSiteClose() {
        secondDriver.quit();
    }
}
