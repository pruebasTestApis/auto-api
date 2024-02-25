package com.example.pe.definitions;

import com.example.base.tasks.GetConsultarDatosUsers;
import com.example.base.tasks.PostPruebaDeApi;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaDatosUsersSD {
    @When("^Se inserta parametros al api consultar datos de un usuario (.*)$")
    public void seInsertaParametrosAlApiConsultarDatosDeUnUsuario(String id) {
        theActorInTheSpotlight().attemptsTo(GetConsultarDatosUsers.sending(id));
    }
}
