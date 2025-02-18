package ch.birri.fhir.server.extension.deployment;

import ch.birri.fhir.server.extension.runtime.hapi.config.FhirContextProducer;
import ch.birri.fhir.server.extension.runtime.hapi.config.FhirServer;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.undertow.deployment.ServletBuildItem;

class FhirServerExtensionProcessor {

    private static final String FEATURE = "fhir-server-extension";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    AdditionalBeanBuildItem buildFhirContextProducer() {
        return new AdditionalBeanBuildItem(FhirContextProducer.class);
    }

    @BuildStep
    ServletBuildItem servlet() {
        ServletBuildItem servletBuildItem = ServletBuildItem.builder("fhir-server-extension", FhirServer.class.getName())
                .addMapping("/fhir/*")
                .build();
        return servletBuildItem;
    }

}
