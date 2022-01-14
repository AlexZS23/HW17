package HomeWork17;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {

    WebDriver firstDriver;

    @BeforeClass
    public void driverInit() {
        firstDriver = BaseTest.driverInit();
    }

    @Test
    public void webSiteCheck1() {
        firstDriver.get("https://korrespondent.net/");
//        System.out.println(firstDriver.getTitle());
        Assert.assertEquals("Новости - последние новости Украины и мира сегодня - Korrespondent.net", firstDriver.getTitle());
    }

    @Test
    public void webSiteCheck2() {
        firstDriver.navigate().to("https://korrespondent.net/ukraine/");
        Assert.assertEquals("https://korrespondent.net/ukraine/", firstDriver.getCurrentUrl());
    }

    @Test
    public void webSiteCheck3() {
        firstDriver.navigate().back();
        Assert.assertEquals("https://korrespondent.net/", firstDriver.getCurrentUrl());
    }

    @AfterClass
    public void webSiteClose() {
        firstDriver.quit();
    }
}
