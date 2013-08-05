package eva.spec

import eva.page.HomePage
import eva.path.PathFixture

class HomePageSpec extends BaseSpecification {

  def "Homepage renders correctly"() {
    given:
      presentation.get(path: PathFixture.RESET)

    when:
      to HomePage

    then:
      at HomePage
  }
}
