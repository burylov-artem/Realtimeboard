package Realtimeboard.manager;

public class Date_Methods {

  String urlHome = "https://realtimeboard.com/signup/",
          fieldName = "//input[@name= 'signup[name]']",
          fieldEmail = "//input[@name= 'signup[email]']",
          fieldPass = "//input[@name= 'signup[password]']",
          buttonSignUp = "//button[@class='signup__submit']",
          pageWelcome = "//div[text()='Добро пожаловать в realtimeboard!']",

  nameError60Characters = "//div[text()='Sorry, your name cannot exceed 60 characters']",
          nameErrorEmpty = "//div[text()='Please enter your name']",
          emailErrorDouble = "//div[text()='Sorry, this email is already registered']",
          emailErrorEmpty = "//div[text()='Please enter your email address']",
          emailErrorSpecSymb = "//div[text()='This doesn’t look like an email address. Please check it for typos " +
                  "and try again.']",
          passErrorOneSymbol = "//div[text()='Password must be 6+ characters']",
          passError60Characters = "//div[text()='Sorry, your password cannot exceed 60 characters']",
          passErrorSpace = "//div[text()='Please enter your password']";
}
