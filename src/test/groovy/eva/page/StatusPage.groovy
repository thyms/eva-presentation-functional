package eva.page

import eva.page.module.TableModule
import eva.path.PathPresentation

class StatusPage extends BasePage {
  static url = PathPresentation.STATUS_SHOW

  static at = {
    title == "Eva Presentation Status"
    header.text() == "Eva Presentation Status"
  }

  static content = {
    header { $("h2") }

    endpoints { module TableModule, $(".endpoints")}

    welcomeField { $('.welcomeField') }
    welcomeText { $('.welcomeText') }
  }
}
