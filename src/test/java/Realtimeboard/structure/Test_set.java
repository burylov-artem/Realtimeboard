package Realtimeboard.structure;

import Realtimeboard.manager.Methods;
import Realtimeboard.manager.Page_Registration;
import org.testng.annotations.Test;

public class Test_set extends Test_basis {

  Methods test = new Methods();

  @Test  //Все данные валидны
  public void signUpSuccess() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), test.randomUserMail(), test.randomUserPass()));
    testMethod.registration_Complete();
  }

  @Test  //Имя с русскоязычными символами
  public void signUp_Name_Rus() {
    testMethod.signUp(new Page_Registration("Проверка", test.randomUserMail(), test.randomUserPass()));
    testMethod.registration_Complete();
  }

  @Test  //Имя с ранее зарегистрированным именем
  public void signUpNameDouble() {
    testMethod.signUp(new Page_Registration("Проверка", test.randomUserMail(), test.randomUserPass()));
    testMethod.registration_Complete();
  }

  @Test  //Имя с англоязычными символами
  public void signUpNameEn() {
    testMethod.signUp(new Page_Registration("Test", test.randomUserMail(), test.randomUserPass()));
    testMethod.registration_Complete();
  }

  @Test  //Имя с циферными символами
  public void signUpNameNumeral() {
    testMethod.signUp(new Page_Registration("123", test.randomUserMail(), test.randomUserPass()));
    testMethod.registration_Complete();
  }

  @Test  //Имя со спецсимволами
  public void signUpNameSpecialSymbol() {
    testMethod.signUp(new Page_Registration("/*+-,.}  {!@#$% ^&*()_=", test.randomUserMail(),
            test.randomUserPass()));
    testMethod.registration_Complete();
  }

  @Test  //Имя с одним символом
  public void signUpNameOneSymbol() {
    testMethod.signUp(new Page_Registration("А", test.randomUserMail(), test.randomUserPass()));
    testMethod.registration_Complete();
  }

  @Test  //Имя со строчными символами
  public void signUpNameLowercaseSymbol() {
    testMethod.signUp(new Page_Registration("fff", test.randomUserMail(), test.randomUserPass()));
    testMethod.registration_Complete();
  }

  @Test  //Имя с прописными символами
  public void signUpNameCapitalSymbol() {
    testMethod.signUp(new Page_Registration("FFF", test.randomUserMail(), test.randomUserPass()));
    testMethod.registration_Complete();
  }

  @Test  //Имя пустое //АС
  public void signUpNameErrorEmpty() {
    testMethod.signUp(new Page_Registration("", test.randomUserMail(), test.randomUserPass()));
    testMethod.signUpNameErrorEmpty();
  }

  @Test  //Имя с 61 символом //АС
  public void signUpName61Symbol() {
    testMethod.signUp(new Page_Registration("AoKqxirzBiTLOPKQrLWkVEKIvdsBMtvsCgcgrUIkFXABWYQtEShOFiCupDhga",
            test.randomUserMail(), test.randomUserPass()));
    testMethod.signUpNameError60Characters();
  }


  @Test  //локальная часть мейла из цифр
  public void signUpEmailNumeral() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), test.randomUserPass()+"@burylov.ru", test.randomUserPass()));
    testMethod.registration_Complete();
  }

  @Test  //локальная часть мейла из спецсимволов
  public void signUpEmailSpecialSymbol1() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), "!$^@burylov"+test.randomUserPass()+".ru", test.randomUserPass()));
    testMethod.registration_Complete();
  }

  @Test  //локальная часть мейла из прописных символов
  public void signUpEmailCapitalSymbol() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), "BURYLOV@burylov"+test.randomUserPass()+".ru", test.randomUserPass()));
    testMethod.registration_Complete();
  }

  @Test  //локальная часть мейла из цифр + букв + спецсимволов
  public void signUpEmailAll() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), "$^123burylov@burylov"+test.randomUserPass()+".ru",
            test.randomUserPass()));
    testMethod.registration_Complete();
  }

  @Test  //локальная часть мейла из спецсимволов АС
  public void signUpEmailSpecialSymbol() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), "^(?!№;%:?*(*{},-+=_.)@burylov.ru",
            test.randomUserPass()));
    testMethod.signUpEmailErrorSpecSymb();
  }

  @Test  //мейл уже зарегистрирован АС
  public void signUpEmailErrorDouble() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), "123@burylov.ru", test.randomUserPass()));
    testMethod.signUpEmailErrorDouble();
  }

  @Test  //мейл пустой АС
  public void signUpEmailErrorEmpty() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), "", test.randomUserPass()));
    testMethod.signUpEmailErrorEmpty();
  }

  @Test  //локальная часть мейла из 65 символов АС
  public void signUpEmailError65Symbol() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), "7NMthfh0RssPzluST3wGep3daqLeKh7HqM94srbV" +
            "QrZcm3ztRvf86FOXf2WVlWhCP@burylov.ru", test.randomUserPass()));
    testMethod.signUpEmailErrorSpecSymb();
  }

  @Test  //локальная часть мейла из русских символов АС
  public void signUpEmailErrorRusSymbol() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), "Бурылов@burylov.ru", test.randomUserPass()));
    testMethod.signUpEmailErrorSpecSymb();
  }

  @Test  //Отсутствует символ @ АС
  public void signUpEmailErrorSymbol() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), "burylov123.ru", test.randomUserPass()));
    testMethod.signUpEmailErrorSpecSymb();
  }

  @Test  //Отсутствует домен нижнего уровня АС
  public void signUpEmailErrorDomainDownEmpty() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), "burylov@.ru", test.randomUserPass()));
    testMethod.signUpEmailErrorSpecSymb();
  }

  @Test  //домен нижнего уровня из спецсимволов АС
  public void signUpEmailErrorDomainDownSpecialSymbol() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), "burylov@%^&*.ru", test.randomUserPass()));
    testMethod.signUpEmailErrorSpecSymb();
  }

  @Test  //домен нижнего уровня из русских символов АС
  public void signUpEmailErrorDomainDownRusSymbol() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), "burylov@проверка.ru", test.randomUserPass()));
    testMethod.signUpEmailErrorSpecSymb();
  }

  @Test  //домен нижнего уровня из цифр
  public void signUpEmailErrorDomainDownNum() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), "burylov@"+test.randomUserPass()+".ru", test.randomUserPass()));
    testMethod.registration_Complete();
  }

  @Test  //Отсутствует домен верхнего уровня АС
  public void signUpEmailErrorDomainUpEmpty() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), "burylov@yandex", test.randomUserPass()));
    testMethod.signUpEmailErrorSpecSymb();
  }

  @Test  //домен верхнего уровня из цифр АС
  public void signUpEmailErrorDomainUpNum() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), "burylov@yandex.123", test.randomUserPass()));
    testMethod.signUpEmailErrorSpecSymb();
  }

  @Test  //домен верхнего уровня из русских символов
  public void signUpEmailErrorDomainUpRus() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), "burylov@yandex.рф", test.randomUserPass()));
    testMethod.signUpEmailErrorSpecSymb();
  }


  @Test  //Пароль комбинированный Анг+Цифры+Спецсимв
  public void signUpPassAll() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), test.randomUserMail(), "FFF123^" +
            "(?=.*d)(?=.*[a-z])(?=.)(?!.*$"));
    testMethod.registration_Complete();
  }

  @Test  //Пароль из русских символов
  public void signUpPassRus() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), test.randomUserMail(), "Проверка" +
            "полявводапароля"));
    testMethod.registration_Complete();
  }

  @Test  //Пароль из прописных символов
  public void signUpPassCapitalSymbol() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), test.randomUserMail(), "FFFFHIUHUW" +
            "IHQIWDUH"));
    testMethod.registration_Complete();
  }

  @Test  //Пароль ранее был ранее зарегистрирован
  public void signUpPassDouble() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), test.randomUserMail(), "FFFFHIUHU" +
            "WIHQIWDUH"));
    testMethod.registration_Complete();
  }


  @Test  //Пароль из одного символа АС
  public void signUpPassOneSymbol() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), test.randomUserMail(), "F"));
    testMethod.signUpPassErrorOneSymbol();
  }

  @Test  //Пароль пустой АС
  public void signUpPassEmpty() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), test.randomUserMail(), ""));
  }

  @Test  //Пароль из 61 символа АС
  public void signUpPass61Symbol() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), test.randomUserMail(), "1dgM5iosq0R" +
            "gjdiqL5Xq17qFaSStPxtO4wKY8UBivr722dM365DmfPuFeReuk"));
    testMethod.signUpPassError60Characters();
  }

  @Test  //Пароль из пробелов АС
  public void signUpPassSpace() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), test.randomUserMail(), "      "));
    testMethod.signUpPassErrorSpace();
  }

  @Test  //Все данные пустые АС
  public void signUpAllEmpty() {
    testMethod.signUp(new Page_Registration("","",""));
  }

    @Test  //Пароль из скрипта
  public void signUpAllScript() {
    testMethod.signUp(new Page_Registration(test.randomUserName(), test.randomUserMail(),"<script>alert(“Hello, world!”)</alert>"));
    testMethod.registration_Complete();
  }
}


