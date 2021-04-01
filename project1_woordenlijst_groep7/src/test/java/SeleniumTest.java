import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Random;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class SeleniumTest {
    private WebDriver driver;
    private String url = "http://localhost:8080/project1_woordenlijst_groep7_war_exploded/";

    @Before
    public void setUp() {
        // vul hier JOUW pad naar chromedriver in
        // Voor Windows (vergeet "\" niet te escapen met een tweede "\")
        // System.setProperty("webdriver.chrome.driver", "C:\\Users\\...\\chromedriver.exe");
        // Voor mac:
        // System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_voeg_toe_met_correcte_velden_voegt_toe(){
        driver.get(url + "Controller?command=pageAdd");

        WebElement inputNaam = driver.findElement(By.id("woord"));
        inputNaam.clear();
        inputNaam.sendKeys("koekje");

        driver.findElement(By.id("bevestig")).click();

        assertEquals("Woordenlijst",driver.getTitle());
        assertEquals("Woordenlijst", driver.findElement(By.tagName("h2")).getText());

        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis,"koekje"));
    }

    @Test
    public void test_voeg_toe_met_leeg_woord_toont_formulier_opnieuw(){
        //Input
        driver.get(url + "Controller?command=pageAdd");

        WebElement inputWoord = driver.findElement(By.id("woord"));
        inputWoord.clear();

        driver.findElement(By.id("bevestig")).click();

        //Kijk na

        assertEquals("Woord toevoegen",driver.getTitle());

        ArrayList<WebElement> errorMessages = (ArrayList<WebElement>) driver.findElements(By.id("errorItem"));

        assertTrue(containsWebElementsWithText(errorMessages,"Woord mag niet leeg zijn."));
        assertFalse(containsWebElementsWithText(errorMessages,"Woord zit al in woordenlijst"));
        assertFalse(containsWebElementsWithText(errorMessages,"Het niveau dat u ingaf is incorrect."));

    }

    @Test
    public void test_statistieken(){
        driver.get(url + "Controller");
        assertEquals("Beheerapplicatie woordenlijst",driver.getTitle());

        ArrayList<WebElement> stats = (ArrayList<WebElement>) driver.findElements(By.tagName("p"));

        assertTrue(containsWebElementsWithText(stats,"Deze woordenlijst heeft 1 woord(en)"));
        assertTrue(containsWebElementsWithText(stats,"Het langste woord is koekje"));
        assertTrue(containsWebElementsWithText(stats,"Het korste woord is koekje"));
        assertTrue(containsWebElementsWithText(stats,"Het gemiddeld aantal verschillende letters van alle woorden 4"));

    }

    private boolean containsWebElementsWithText(ArrayList<WebElement> elements, String text)
    {
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                return true;
            }
        }
        return false;
    }
}
