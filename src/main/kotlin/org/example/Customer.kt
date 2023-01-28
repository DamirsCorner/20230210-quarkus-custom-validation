package org.example

import javax.validation.constraints.NotNull

class Customer {
    @NotNull
    var type: CustomerType? = null
    @NotNull(groups = [CustomerValidationGroups.NaturalPerson::class])
    var firstName: String? = null
    @NotNull(groups = [CustomerValidationGroups.NaturalPerson::class])
    var lastName: String? = null
    @NotNull(groups = [CustomerValidationGroups.LegalPerson::class])
    var organizationName: String? = null
}