package eva.spec

import geb.spock.GebReportingSpec
import groovyx.net.http.RESTClient

class BaseSpecification extends GebReportingSpec {
  static ConfigObject config = initializeConfig()
  static RESTClient stubulator = new RESTClient(config.stubulator.baseUrl)
  static RESTClient presentation = new RESTClient(config.presentation.baseUrl)

  private static ConfigObject initializeConfig() {
    return new ConfigSlurper(System.getProperty('test.env')).parse(configFileUrl)
  }

  private static URL getConfigFileUrl() {
    File file = new File('./src/test/groovy/eva/Config.groovy')
    if (!file.exists()) { // This check is done for tests run on IDE
      file = new File('./presentation-functional/src/test/groovy/eva/Config.groovy')
    }

    return file.toURI().toURL()
  }
}
