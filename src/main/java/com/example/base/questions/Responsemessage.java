package com.example.base.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class Responsemessage {
    public static Question<String> getResponsemessage(){
        return actor -> SerenityRest.lastResponse().headers().get("Responsemessage").toString().replace("Responsemessage=","");
    }

}
