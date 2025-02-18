package ch.birri.fhir.server.extension.runtime.hapi.config;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.server.IResourceProvider;
import ca.uhn.fhir.rest.server.RestfulServer;
import io.quarkus.arc.All;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;

import java.util.List;

@WebServlet
public class FhirServer extends RestfulServer {

    @Inject
    @All
    List<IResourceProvider> resourceProviders;

    @Inject
    FhirContext fhirContext;

    @Override
    public void initialize() {
        setFhirContext(fhirContext);
        setResourceProviders(resourceProviders);
    }
}