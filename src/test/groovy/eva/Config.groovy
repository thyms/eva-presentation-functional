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
      baseUrl = "http://eva-presentation-functional01.herokuapp.com/"
      baseContext = ""
    }
    stubulator  {
      baseUrl = "http://eva-presentation-stubulator01.herokuapp.com/"
      baseContext = ""
    }
  }
}