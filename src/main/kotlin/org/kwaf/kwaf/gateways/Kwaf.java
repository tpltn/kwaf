//package org.kwaf.kwaf.gateways;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.kwaf.kwaf_ingress.AppProperties;
//import org.kwaf.kwaf_ingress.entities.Event;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Mono;
//import reactor.core.scheduler.Schedulers;
//
//import java.net.URI;
//import java.text.SimpleDateFormat;
//
//@Component
//public class Kwaf {
//    private final AppProperties properties;
//
//    public Kwaf(AppProperties properties) {
//        this.properties = properties;
//    }
//
//    public Mono<Event> sendEvent(Event event) {
//        Gson gson = new GsonBuilder().setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").toPattern()).create();
//        String payload = gson.toJson(event);
//
//        // TODO: parse response body and return created event
//        return performRequest(payload).then(Mono.just(event));
//    }
//
//    private Mono<HttpResponse> performRequest(String payload) {
//        Mono<HttpResponse> blockingWrapper = Mono.fromCallable(() -> {
//            HttpClient httpClient = HttpClientBuilder.create().build();
//
//            HttpPost request = new HttpPost();
//            request.setURI(new URI(String.format("%s/events", properties.getKwafURL())));
//            request.setHeader("Content-Type", "application/json;charset=UTF-8");
//            request.setEntity(new StringEntity(payload));
//
//            HttpResponse response = httpClient.execute(request);
//
//            if (response.getStatusLine().getStatusCode() != 200) {
//                String body = new String(response.getEntity().getContent().readAllBytes());
//                throw new RuntimeException(String.format("Invalid response: %s", body));
//            }
//
//            return response;
//        });
//
//        return blockingWrapper.subscribeOn(Schedulers.elastic());
//    }
//}
