package com.example.base.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetpruebaDeApi implements Task {
    private static final String URL_PATH = "/users?page={page}";
    private final String page;

    public GetpruebaDeApi(String page) {
        this.page = page;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(Get.resource(URL_PATH)
                    .with(request -> request
                            .relaxedHTTPSValidation()
                            .pathParam("page",page)
                            .contentType(ContentType.JSON)
                            .header("accept", "application/json")
                            .header("Content-Type", "application/json")
                            .log().all()
                    ));
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.toString());
        }
    }

    public static Performable sending(String page){
        return instrumented(GetpruebaDeApi.class, page);
    }
}
