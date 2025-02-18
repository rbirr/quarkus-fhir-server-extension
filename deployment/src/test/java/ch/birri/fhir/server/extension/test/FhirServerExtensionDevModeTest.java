package ch.birri.fhir.server.extension.test;

import io.restassured.RestAssured;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.quarkus.test.QuarkusDevModeTest;

import static org.hamcrest.Matchers.containsString;

public class FhirServerExtensionDevModeTest {

    // Start hot reload (DevMode) test with your extension loaded
    @RegisterExtension
    static final QuarkusDevModeTest devModeTest = new QuarkusDevModeTest()
            .setArchiveProducer(() -> ShrinkWrap.create(JavaArchive.class));

    @Test
    public void checkIfMetadataExistsInDevMode() {
        RestAssured.when().get("/fhir/metadata").then().statusCode(200).body(containsString("CapabilityStatement"));
    }
}
