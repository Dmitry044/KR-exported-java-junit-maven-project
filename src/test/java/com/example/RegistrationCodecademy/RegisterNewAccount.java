package com.example.RegistrationCodecademy;

import java.time.Duration;

import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterNewAccount {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/Users/dmitryavdeenko/Documents/Tools/chromedriver_mac_arm64/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testNew() throws Exception {
    driver.get("https://www.codecademy.com/");
    driver.findElement(By.id("email")).click();

    driver.findElement(By.id("email")).sendKeys("test+34@test.ii");
    driver.findElement(By.id("password")).click();

    driver.findElement(By.id("password")).sendKeys("QWEqwe123$$");

    driver.findElement(By.xpath("//button[@type='submit']")).click();

    Boolean isLogin = driver.getTitle().equals("Welcome | Codecademy");
    //Assert.assertTrue(isLogin);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
