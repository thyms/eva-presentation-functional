package eva.path

import eva.spec.BaseSpecification

enum PathFixture {
  BASE(BaseSpecification.config.presentation.baseContext + "/fixture"),
  RESET("$BASE/reset"),
  STATUS("$BASE/status"),
  STATUS_COMMIT_HASH("$STATUS/commitHash"),
  STATUS_APPLICATION_VERSION("$STATUS/applicationVersion")

  String path

  PathFixture(String path) {
    this.path = path
  }

  @Override
  String toString() {
    this.path
  }
}