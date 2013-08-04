package eva.page

import eva.path.PathPresentation

class HomePage extends BasePage {

  static url = PathPresentation.BASE
  static at = { title == "Welcome to Eva Presentation" }

  static content = {
    items { $('.item') }
  }
}
