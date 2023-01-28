package org.example

import javax.validation.groups.Default

interface CustomerValidationGroups {
    interface NaturalPerson : Default
    interface LegalPerson : Default
}