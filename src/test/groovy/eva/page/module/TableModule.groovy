package eva.page.module

import geb.Module

class TableModule extends Module {

  static content = {
    header { $("h4") }
    rows { moduleList RowEntryModule, $("tr") }
  }
}