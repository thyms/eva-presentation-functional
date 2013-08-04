package eva.spec

import groovyx.net.http.ContentType
import eva.page.HomePage
import eva.path.PathFixture
import eva.path.PathStubulator

class HomePageSpec extends BaseSpecification {

  def "Homepage renders correctly"() {
    given:
      presentation.get(path: PathFixture.RESET)

      stubulator.post(path: PathStubulator.ITEMS,
                      body: [item1: 'item-1', item2: 'item-2'],
                      requestContentType: ContentType.JSON)

    when:
      to HomePage

    then:
      items*.text() == ['item1', 'item2']
  }
}
