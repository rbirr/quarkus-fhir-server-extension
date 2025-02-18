package ch.birri.fhir.server.extension.runtime.hapi.config;

import ca.uhn.fhir.context.FhirVersionEnum;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import jakarta.enterprise.context.ApplicationScoped;

@ConfigMapping(prefix = "hapi.fhir")
@ConfigRoot(phase = ConfigPhase.RUN_TIME)
public interface HapiFhirConfig {
    /**
     * The FHIR-Version of the server
     */
    @WithDefault("R4")
    FhirVersionEnum version();

}
