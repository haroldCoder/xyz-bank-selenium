import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\koderx\\Desktop\\Nueva carpeta\\banco\\src\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        // darle tiempo de espera a la pagina

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Encuentra el elemento del botón
        WebElement buttonCustomer = driver
                .findElement(By.xpath("//button[contains(@class, 'btn btn-primary btn-lg')]"));

        // Haz clic en el botón
        buttonCustomer.click();
        List<WebElement> buttonSelect = driver
                .findElements(By.xpath("//option[contains(@class, 'ng-binding ng-scope')]"));
        buttonSelect.get(1).click();

        WebElement buttonLogin = driver.findElement(By.xpath("//button[contains(@class, 'btn btn-default')]"));
        buttonLogin.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        List<WebElement> buttonDeposit = driver.findElements(By.xpath("//button[contains(@class, 'btn btn-lg tab')]"));
        buttonDeposit.get(1).click();

        WebElement inputAmout = driver.findElement(By.cssSelector("input[ng-model='amount']"));
        inputAmout.sendKeys("10");

        WebElement sendAmount = driver.findElement(By.xpath("//button[contains(@class, 'btn btn-default')]"));
        sendAmount.click();

        WebElement spansuccess = driver.findElement(By.cssSelector("span[ng-show='message']"));
 
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (spansuccess.isDisplayed()) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("alert('El deposito se completo');");
        } else {

        }
    }
}
