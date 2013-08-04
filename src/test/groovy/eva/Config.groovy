package eva

presentation {
  baseUrl = "http://localhost:5000"
  baseContext = ""
}
stubulator {
  baseUrl = "http://localhost:5001"
  baseContext = ""
}

environments {
  functional01 {
    presentation {
      baseUrl = "http://eva.functional01.presentation.dk.com"
      baseContext = ""
    }
    stubulator  {
      baseUrl = "http://eva.stubulator01.presentation.dk.com"
      baseContext = ""
    }
  }
}