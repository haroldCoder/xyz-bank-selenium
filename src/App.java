import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\koderx\\Desktop\\Nueva carpeta\\banco\\src\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        //darle tiempo de espera a la pagina

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Encuentra el elemento del botón
        WebElement buttonCustomer = driver.findElement(By.xpath("//button[contains(@class, 'btn btn-primary btn-lg')]"));

        // Haz clic en el botón
        buttonCustomer.click();
        List<WebElement> buttonSelect = driver.findElements(By.xpath("//option[contains(@class, 'ng-binding ng-scope')]"));
        buttonSelect.get(1).click();

        WebElement buttonLogin = driver.findElement(By.xpath("//button[contains(@class, 'btn btn-default')]"));
        buttonLogin.click();
    }
}
