package org.example

import kotlin.reflect.KClass

enum class CustomerType(val validationGroup: KClass<*>) {
    NATURAL_PERSON(CustomerValidationGroups.NaturalPerson::class),
    LEGAL_PERSON(CustomerValidationGroups.LegalPerson::class)
}