package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;


import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class SearchStepDefinitions {

    private final int SUCCESS_CODE = 200;
    private final int ERROR_CODE  = 404;

    @When("he calls endpoint {string}")
    public void heCallsEndpoint(final String arg0) {
        SerenityRest.given().get(arg0);
    }

    @Then("he sees the results displayed for {string}")
    public void heSeesTheResultsDisplayedForFruit(String fruit) {
        restAssuredThat(response -> response.statusCode(SUCCESS_CODE));
        restAssuredThat(response -> response.body("title",containsStringIgnoringCase(fruit)));
    }

    @Then("Verify no results are displayed")
    public void he_Doesn_Not_See_The_Results() {
        restAssuredThat(response -> response.statusCode(ERROR_CODE));
        restAssuredThat(response -> response.body(containsString("error")));
    }
}
