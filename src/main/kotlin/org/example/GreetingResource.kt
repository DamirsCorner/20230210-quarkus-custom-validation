package org.example

import javax.validation.ConstraintViolationException
import javax.validation.Valid
import javax.validation.Validator
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/hello")
class GreetingResource(
    val validator: Validator
) {

    @Path("/validate")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun validate(@Valid customer: Customer): Response {
        validator.validate(customer, customer.type!!.validationGroup.java).let {
            if (it.isNotEmpty()) {
                throw ConstraintViolationException(it)
            }
        }

        return Response.noContent().build()
    }
}