package org.example

import javax.validation.constraints.NotNull

class Customer {
    @NotNull
    var type: CustomerType? = null
    var firstName: String? = null
    var lastName: String? = null
    var organizationName: String? = null
}