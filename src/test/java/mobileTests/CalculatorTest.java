
package mobileTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseTest {

    private void click(String text) {
        driver.findElement(By.xpath("//android.widget.Button[@text='" + text + "']")).click();
    }

    private String getResult() {
        return driver.findElement(By.id("com.android.calculator2:id/result")).getText();
    }

    @Test(priority=0)
    public void testAddition() {
        click("1");
        click("2");
        click("+");
        click("8");
        click("=");

        String result = getResult();
        System.out.println("Addition Result: " + result);
        Assert.assertEquals(result, "20");
    }

    @Test(priority=1)
    public void testSubtraction() {
        click("5");
        click("0");
        click("-");
        click("2");
        click("0");
        click("=");

        String result = getResult();
        System.out.println("Subtraction Result: " + result);
        Assert.assertEquals(result, "30");
    }

    @Test(priority=2)
    public void testMultiplication() {
        click("7");
        click("*");
        click("6");
        click("=");

        String result = getResult();
        System.out.println("Multiplication Result: " + result);
        Assert.assertEquals(result, "42");
    }

    @Test(priority=3)
    public void testDivision() {
        click("3");
        click("6");
        click("÷");
        click("6");
        click("=");

        String result = getResult();
        System.out.println("Division Result: " + result);
        Assert.assertEquals(result, "6");
    }

    @Test(priority=4)
    public void testDivideByZero() {
        click("9");
        click("÷");
        click("0");
        click("=");

        String result = getResult();
        System.out.println("Divide by Zero Result: " + result);
        Assert.assertTrue(result.toLowerCase().contains("Can't divide by zero"));
    }
}
