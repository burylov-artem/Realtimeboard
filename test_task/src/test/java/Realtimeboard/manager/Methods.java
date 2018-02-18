package Realtimeboard.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Methods {
  ChromeDriver wd;

  Date_Methods date = new Date_Methods();
  Random random = new Random();

  public void start() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.manage().window().maximize();
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //установка неявного ожидания
  }

  public void signUp(Page_Registration DateSignUp) {

    wd.get(date.urlHome);
    type(By.xpath(date.fieldName), DateSignUp.getUsername());
    type(By.xpath(date.fieldEmail), DateSignUp.getEmail());
    type(By.xpath(date.fieldPass), DateSignUp.getUserpassword());
    wd.findElement(By.xpath(date.buttonSignUp)).click();
  }

  public void registration_Complete() {
    wd.findElements(By.xpath(date.pageWelcome));
  }

  public void type(By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public String randomUserName() {
    String number = "";
    String name = "";
    for (int i = 0; i < 7; i++) {
      number += random.nextInt(9);
    }
    name = "burylov.artem_"+number;
    return name;
  }

  public String randomUserMail() {
    String number = "";
    String mail = "";
    for (int i = 0; i < 7; i++) {
      number += random.nextInt(9);
    }
    mail = "burylov.artem@test"+number+".ru";
    return mail;
  }

  public String randomUserPass() {
    String pass = "";
    for (int i = 0; i < 9; i++) {
      pass += random.nextInt(9);
    }
    return pass;
  }


  public void stop() {
    wd.quit();
  }

  public void signUpNameError60Characters() {
    wd.findElement(By.xpath(date.nameError60Characters));
  }

  public void signUpNameErrorEmpty() {
    wd.findElement(By.xpath(date.nameErrorEmpty));
  }

  public void signUpEmailErrorDouble() {
    wd.findElement(By.xpath(date.emailErrorDouble));
  }

  public void signUpEmailErrorEmpty() {
    wd.findElement(By.xpath(date.emailErrorEmpty));
  }

  public void signUpEmailErrorSpecSymb() {
    wd.findElement(By.xpath(date.emailErrorSpecSymb));
  }

  public void signUpPassErrorOneSymbol() {
    wd.findElement(By.xpath(date.passErrorOneSymbol));
  }

  public void signUpPassError60Characters() {
    wd.findElement(By.xpath(date.passError60Characters));
  }

  public void signUpPassErrorSpace() {
    wd.findElement(By.xpath(date.passErrorSpace));
  }


}


