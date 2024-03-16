package com.example.base.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class Responsecode {
    public static Question<String> getResponsecode(){
        return actor -> SerenityRest.lastResponse().headers().get("Responsecode").toString().replace("Responsecode=","");
    }
}
