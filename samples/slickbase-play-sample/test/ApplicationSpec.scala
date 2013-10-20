import org.scalatest._

import play.api.test._
import play.api.test.Helpers._

class ApplicationSpec extends UnitSpec {

  "Application" should {

    "send 404 on a bad request" in running(FakeApplication()) {
      route(FakeRequest(GET, "/boum")) shouldBe None
    }

    "render the index page" in running(FakeApplication()) {
      val home = route(FakeRequest(GET, "/")).get

      status(home) shouldBe OK
      contentType(home).value shouldBe "text/html"
    }
  }
}
