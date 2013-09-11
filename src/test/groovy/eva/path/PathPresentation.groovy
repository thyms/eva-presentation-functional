package eva.path

import eva.spec.BaseSpecification

enum PathPresentation {
  BASE(BaseSpecification.config.presentation.baseContext),
  STATUS("$BASE/admin/status"),
  API_1_STATUS("$BASE/api/1/status")

  String path

  PathPresentation(String path) {
    this.path = path
  }

  @Override
  String toString() {
    this.path
  }
}