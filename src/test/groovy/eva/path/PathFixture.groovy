package eva.path

import eva.spec.BaseSpecification

enum PathFixture {
  BASE(BaseSpecification.config.presentation.baseContext + "/admin/fixture"),
  RESET("$BASE/reset"),
  CONFIGS("$BASE/configs")

  String path

  PathFixture(String path) {
    this.path = path
  }

  @Override
  String toString() {
    this.path
  }
}