package eva.spec

import eva.page.StatusPage
import eva.path.PathFixture
import eva.path.PathPresentation

class StatusPageSpec extends BaseSpecification {

  def "Status page renders endpoints"() {
    given:
      presentation.get(path: PathFixture.RESET)

    when:
      toAt StatusPage

    then:
      endpoints.header.text() == 'Endpoints'
      endpoints.rows[0].cells*.text() == ["myKey", "myValue"]
  }

  def "Status should be available as json feed"() {
    given:
      presentation.get(path: PathFixture.RESET)

    when:
      def response = presentation.get(path: "${PathPresentation.STATUS_SHOW}",
                                      headers: ['Accept': 'application/json'])

    then:
      def keys = response.data.keys
      keys.myKey == [myInnerKey: "myValue"]
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