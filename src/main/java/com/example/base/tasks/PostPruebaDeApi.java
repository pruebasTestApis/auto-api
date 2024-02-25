package com.example.base.tasks;

import com.example.base.util.ApiCommons;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostPruebaDeApi implements Task {
    private static final String URL_PATH = "/users";
    private static final String JSON_REQUEST = "/request/pruebaDeApi.json";
    private final String name, job;

    public PostPruebaDeApi(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(Post.to(URL_PATH)
                    .with(request -> request
                            .relaxedHTTPSValidation()
                            .contentType(ContentType.JSON)
                            .header("accept", "application/json")
                            .header("Content-Type", "application/json")
                            .log().all()
                            .body(ApiCommons.getTemplate(JSON_REQUEST)
                                .replace("name",name)
                                .replace("job",job)
                            )
                    ));
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.toString());
        }
    }

    public static Performable sending(String name, String job){
        return instrumented(PostPruebaDeApi.class, name, job);
    }
}
