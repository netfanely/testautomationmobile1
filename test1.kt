import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.By
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

fun main(){
  // Configuracion de DesiredCapabilities
  val capabilities = DesiredCapabilities().apply{
    setCapability(MobileCapabilityType.PLATFORM_NAME,"Android")
    setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554") // Nombre del dispositivo/emulador
    setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome") // Usar navegador Chrome
    setCapability("chromedriverExecutable","/path/to/chromedriver") // Ruta al Chromedriver
  }

  //inicializar el AppiumDriver
  val driver: AppiumDriver<*>= AndroidDriver(URL("http://localhost:4723/wd/hub"), capabilities)

  try{
    //Acceder a google
    driver.get("https://www.google.com")

    //Esperar a que el campo de búsqueda esté presente y buscar "Avengers"
    val searchBox = driver.findElement(By.name("q"))
    searchBox.sendKeys("Avengers")
    searchBox.submit()

    //Puedes añadir más interacciones aquí según lo requieras
  } finally {
    // Cerrar la sesión del driver
    driver.quit()
  }
}
