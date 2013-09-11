package eva.page

import eva.page.module.TableModule
import eva.path.PathPresentation

class StatusPage extends BasePage {
  static url = PathPresentation.STATUS

  static at = {
    title == "Eva Presentation Admin"
    header.text() == "Eva Presentation Status"
  }

  static content = {
    header { $("h2") }

    status(required: false) { name -> module TableModule, $(".$name")}
  }
}
