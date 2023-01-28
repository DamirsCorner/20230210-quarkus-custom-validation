package org.example

import io.quarkus.hibernate.validator.ValidatorFactoryCustomizer
import org.hibernate.validator.BaseHibernateValidatorConfiguration
import org.hibernate.validator.cfg.defs.NotNullDef
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CustomerValidatorFactoryCustomizer : ValidatorFactoryCustomizer {
    override fun customize(configuration: BaseHibernateValidatorConfiguration<*>) {
        val constraintMapping = configuration.createConstraintMapping()

        constraintMapping
            .type(Customer::class.java)
            .field(Customer::firstName.name)
                .constraint(NotNullDef().groups(CustomerValidationGroups.NaturalPerson::class.java))
            .field(Customer::lastName.name)
                .constraint(NotNullDef().groups(CustomerValidationGroups.NaturalPerson::class.java))
            .field(Customer::organizationName.name)
                .constraint(NotNullDef().groups(CustomerValidationGroups.LegalPerson::class.java))

        configuration.addMapping(constraintMapping)
    }
}