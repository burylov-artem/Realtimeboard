package Realtimeboard.structure;

import Realtimeboard.manager.Methods;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Test_basis {

  protected static final Methods testMethod = new Methods();

  @BeforeSuite
  public void setUp() {
    testMethod.start();
  }

  @AfterSuite
  public void tearDown() {
    testMethod.stop();
  }

}
