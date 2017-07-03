package Realtimeboard.manager;

import Realtimeboard.Basic_set_of_methods.DateAuthorization;
import Realtimeboard.Basic_set_of_methods.DateLetter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by mr.robot on 19.02.2017.
 */
public class TestMethods {
  ChromeDriver wd;

  date_testmethods date;

  public TestMethods() {
    date = new date_testmethods();
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void start() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.manage().window().maximize();
  }

  public void send() {
    String keysPressed = Keys.chord(Keys.CONTROL, Keys.RETURN);
    wd.findElement(By.name(date.field_subject)).sendKeys(keysPressed);
  }

  public void writeLetter(DateLetter DateLetter) throws InterruptedException {
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.findElement(By.linkText(date.button_send)).click();
    wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    type(By.cssSelector(date.field_recipient), DateLetter.getRecipient());
    type(By.name(date.field_subject), DateLetter.getSubject());

    wd.findElement(By.name(date.field_subject)).sendKeys(Keys.TAB);
    moveOnFrame();
    writeInFrame(DateLetter);
    outOfTheFrame();
  }

  public void writeInFrame(DateLetter DateLetter) {
    wd.getKeyboard().sendKeys(DateLetter.getText());
  }

  public void outOfTheFrame() {
    wd.switchTo().defaultContent();
  }

  public void moveOnFrame() {
    wd.switchTo().frame(1);
  }

  public void authorization(DateAuthorization dateAuthorization) {


    wd.get(date.url_home);
    type(By.id(date.field_login), dateAuthorization.getUsername());
    type(By.id(date.field_pass), dateAuthorization.getUserpassword());

    wd.findElement(By.id(date.button_auth)).click();
  }

  public void type( By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void stop() {
    wd.quit();
  }

}
