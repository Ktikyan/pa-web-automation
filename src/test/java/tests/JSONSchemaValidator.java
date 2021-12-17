    /*        Picsart Automation Task (Web)       */

    /*           JSON Schema Validator            */


package tests;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;


public class JSONSchemaValidator extends TestManager {

    @Test
    public void validateJSONSchema() {
        File schema = new File("src\\main\\resources\\JSONSchema.json");                                    // creating a new file with the pathname of JSONSchema.json file
        given().get("https://api.picsart.com/localizations/en/messages?project=reusable_components,photo_editor")
                .then().assertThat().body(matchesJsonSchema(schema));                                                // gets the response and compares it with our schema
    }
}