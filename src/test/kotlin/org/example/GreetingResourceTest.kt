package org.example

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class GreetingResourceTest {

    @Test
    fun testCustomerTypeNull() {
        given()
            .contentType("application/json")
            .body("{}")
        .`when`()
            .post("/hello/validate")
        .then()
            .statusCode(400)
            .body("title", `is`("Constraint Violation"))
            .body("violations.size()", `is`(1))
    }

    @Test
    fun testCustomerTypeInvalid() {
        given()
            .contentType("application/json")
            .body("""{"type": "FOO"}""")
        .`when`()
            .post("/hello/validate")
        .then()
            .statusCode(400)
            .body("objectName", `is`("Customer"))
            .body("attributeName", `is`("type"))
    }

    @Test
    fun testInvalidNaturalPerson() {
        given()
            .contentType("application/json")
            .body("""{"type": "NATURAL_PERSON"}""")
        .`when`()
            .post("/hello/validate")
        .then()
            .statusCode(400)
            .body("title", `is`("Constraint Violation"))
            .body("violations.size()", `is`(2))
    }

    @Test
    fun testInvalidLegalPerson() {
        given()
            .contentType("application/json")
            .body("""{"type": "LEGAL_PERSON"}""")
        .`when`()
            .post("/hello/validate")
        .then()
            .statusCode(400)
            .body("title", `is`("Constraint Violation"))
            .body("violations.size()", `is`(1))
    }
}