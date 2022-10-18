package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.ui.Button;

public class AuthenticationStepDefinitions {
    @Given("{actor} is on login page")
    public void on_the_login_page (Actor actor) {
        actor.attemptsTo(Open.url("https://www.saucedemo.com/"));
    }

    @When("{actor} login with valid credentials")
    public void login_with_valid_credentials (Actor actor) {
        actor.attemptsTo(
                Enter.theValue("standard_user").into("#user-name"),
                Enter.theValue("secret_sauce").into("#password"),
                Click.on(Button.containingText("Login")
                )
        );
    }
    @Then("{actor} he should be presented with product")
    public void he_should_be_presented_with_product (Actor actor) {
        actor.attemptsTo(
                Ensure.that(Text.of(".title")).isEqualTo("Product")
        );

    }
}
