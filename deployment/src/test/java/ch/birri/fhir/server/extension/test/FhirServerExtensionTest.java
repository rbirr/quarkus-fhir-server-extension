package ch.birri.fhir.server.extension.test;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.quarkus.test.QuarkusUnitTest;

import static org.hamcrest.Matchers.containsString;

public class FhirServerExtensionTest {

    @RegisterExtension
    static final QuarkusUnitTest config = new QuarkusUnitTest()
            .withEmptyApplication();

    @Test
    public void checkIfMetadataExists() {
        RestAssured.when().get("/fhir/metadata").then().statusCode(200).body(containsString("CapabilityStatement"));
    }
}
