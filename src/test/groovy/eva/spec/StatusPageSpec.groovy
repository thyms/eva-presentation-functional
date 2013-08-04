package eva.spec

import groovyx.net.http.ContentType
import eva.page.StatusPage
import eva.path.PathFixture
import eva.path.PathPresentation

class StatusPageSpec extends BaseSpecification {

  def "Status page renders endpoints"() {
    given:
      presentation.get(path: PathFixture.RESET)

      presentation.post(path: PathFixture.CONFIGS,
                        body: [endpoint: [ app1: [url: "http://my.app.1", port: "8000", context: "/myContext1"],
                                           app2: [url: "http://my.app.2", port: "8222", context: "/myContext2"]]],
                        requestContentType: ContentType.JSON)

    when:
      toAt StatusPage

    then:
      endpoints.header.text() == 'Endpoints'
      endpoints.rows[0].cells*.text() == ["app1", "http://my.app.1:8000/myContext1"]
      endpoints.rows[1].cells*.text() == ["app2", "http://my.app.2:8222/myContext2"]
  }


  def "Status page renders application properties"() {
    when:
      toAt StatusPage

    then:
      applicationProperties.header.text() == 'Application Properties'
      applicationProperties.rows[0].cells*.text() == ["git", "someHash!!!"]
  }

  def "Status should be available as json feed"() {
    given:
      presentation.get(path: PathFixture.RESET)

      presentation.post(path: PathFixture.CONFIGS,
                        requestContentType: ContentType.JSON,
                        body: [endpoint: [app1: [url: "http://my.app.1", port: "8000", context: "/myContext1"],
                                          app2: [url: "http://my.app.2", port: "8222", context: "/myContext2"]]])

    when:
      def response = presentation.get(path: "${PathPresentation.STATUS_SHOW}",
                                      headers: ['Accept': 'application/json'])

    then:
      def endpoints = response.data.endpoints
      endpoints.app1.url == "http://my.app.1"
      endpoints.app1.port == "8000"
      endpoints.app1.context == "/myContext1"

      endpoints.app2.url == "http://my.app.2"
      endpoints.app2.port == "8222"
      endpoints.app2.context == "/myContext2"
  }

  def "Status have a text field that updates welcome text"() {
    given:
      toAt StatusPage
      welcomeText.text() == "Welcome to "

    when:
      welcomeField << 'Presentation'

    then:
      welcomeText.text() == "Welcome to Presentation"
  }
}