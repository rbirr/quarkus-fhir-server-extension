package ch.birri.fhir.server.extension.runtime.hapi.config;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@ApplicationScoped
public class FhirContextProducer {

    @Inject
    HapiFhirConfig config;

    @Produces
    @DefaultBean
    @Singleton
    public FhirContext fhirContext() {
        if(FhirVersionEnum.R4.equals(config.version())) {
            return FhirContext.forR4();
        } else if(FhirVersionEnum.R5.equals(config.version())) {
            return FhirContext.forR5();
        }
        throw new IllegalArgumentException("Unsupported FHIR version: " + config.version());
    }
}
