package com.example.pe.definitions;

import com.example.base.tasks.GetpruebaDeApi;
import com.example.base.tasks.PostPruebaDeApi;
import io.cucumber.java.en.*;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaUserSD {
    @When("^Se inserta parametros al api users (.*)$")
    public void seInsertaParametrosAlApiUsers(String page) {
        theActorInTheSpotlight().attemptsTo(GetpruebaDeApi.sending(page));
    }
}
