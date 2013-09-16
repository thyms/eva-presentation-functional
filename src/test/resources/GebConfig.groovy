import geb.report.PageSourceReporter
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

waiting {
  timeout = 2
}

baseUrl = "http://localhost:5000"
reportsDir = 'build/reports'
reporter = new PageSourceReporter()

def caps = new DesiredCapabilities(["javascriptEnabled": true,
                                    "takeScreenshot": true])

driverRemote = {
  def driverUrl = System.getProperty("geb.driverUrl", "http://localhost")
  def driverPort = System.getProperty("geb.driverPort", "8910")
  new RemoteWebDriver(new URL("$driverUrl:$driverPort"), caps)
}

environments {
  remote {
    driver = driverRemote
  }

  functional01 {
    baseUrl = "http://eva-presentation-functional01.herokuapp.com"
    driver = driverRemote
  }
}