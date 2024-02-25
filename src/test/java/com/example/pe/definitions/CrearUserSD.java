package com.example.pe.definitions;

import com.example.base.tasks.GetpruebaDeApi;
import com.example.base.tasks.PostPruebaDeApi;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CrearUserSD {

    @When("^Se inserta parametros para crear al api users (.*) (.*)$")
    public void seInsertaParametrosParaCrearAlApiUsers(String name, String job) {
        theActorInTheSpotlight().attemptsTo(PostPruebaDeApi.sending(name, job));
    }
}
