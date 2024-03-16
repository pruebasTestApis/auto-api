package com.example.pe.definitions;

import com.example.base.questions.ResponseStatus;
import com.example.base.questions.Responsecode;
import com.example.base.questions.Responsemessage;
import com.example.base.util.ApiCommons;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.*;


public class CommonStepDefinition {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que {actor} es una API")
    public void queActorEsUnaAPI(Actor actor) {
        ApiCommons.URL_BASE = "https://reqres.in/api";

        actor.whoCan(CallAnApi.at(ApiCommons.URL_BASE));
    }


    @Then("^valida la respuesta sea (.*)$")
    public void validaLaRespuestaSea(int i) {
        System.out.println("RESP:" +lastResponse().getBody().asString());
        theActorInTheSpotlight().should(seeThat("El código de respuesta", ResponseStatus.getResponseStatus(), equalTo(i)));
    }

    @Given("que {actor} es una API publica")
    public void queAlumnosEsUnaAPIPublica(Actor actor) {
        ApiCommons.URL_BASE = "https://ed74-201-218-130-91.ngrok-free.app";

        actor.whoCan(CallAnApi.at(ApiCommons.URL_BASE));
    }

    @Then("^valida que el mensaje de respuesta en Responsemessage sea (.*)$")
    public void validaQueElMensajeDeRespuestaEnResponsemessageSea(String responseMessage) {
        theActorInTheSpotlight().should(seeThat("Mesaje es: ", Responsemessage.getResponsemessage(), is(responseMessage)));
    }

    @Then("^valida que el codigo de respuesta en Responsecode sea (.*)$")
    public void validaQueElCodigoDeRespuestaEnResponsecodeSea(String responseCode) {
        theActorInTheSpotlight().should(seeThat("Mensaje es: ", Responsecode.getResponsecode(), is(responseCode)));
    }
}
