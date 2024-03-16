package com.example.base.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class ResponseBody {
    public static Question<String> getLastMessage(){
        return actor -> SerenityRest.lastResponse().body().jsonPath().getString("message");
    }
}
