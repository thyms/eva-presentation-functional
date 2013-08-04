package eva.path

import eva.spec.BaseSpecification

enum PathStubulator {
  BASE(BaseSpecification.config.stubulator.baseContext),
  ITEMS("$BASE/items")

  String path

  PathStubulator(String path) {
    this.path = path
  }

  @Override
  String toString() {
    this.path
  }
}