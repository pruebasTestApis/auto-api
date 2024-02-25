package com.example.pe.definitions;

import com.example.base.tasks.GetConsultaAlumnos;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaAlumnosSD {
    @When("^Se inserta parametros al api consultar datos de alumnos (.*)$")
    public void seInsertaParametrosAlApiConsultarDatosDeAlumnos(String id) {
        theActorInTheSpotlight().attemptsTo(GetConsultaAlumnos.sending(id));
    }
}
