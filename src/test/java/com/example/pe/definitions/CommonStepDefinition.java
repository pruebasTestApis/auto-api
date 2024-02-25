package com.example.pe.definitions;

import com.example.base.questions.ResponseCode;
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
        theActorInTheSpotlight().should(seeThat("El código de respuesta", ResponseCode.getStatus(), equalTo(i)));
    }

    @Given("que {actor} es una API publica")
    public void queAlumnosEsUnaAPIPublica(Actor actor) {
        ApiCommons.URL_BASE = "https://31e4-201-218-130-90.ngrok-free.app";

        actor.whoCan(CallAnApi.at(ApiCommons.URL_BASE));
    }
}
