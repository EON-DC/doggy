package com.doggy.mapper;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;

@Component
public class PlaceHolderGrep {

    private HashMap<Integer, String> store ;

    private String url = "https://catfact.ninja/fact?max_length=140";


    public PlaceHolderGrep() {
        store = new HashMap<>();
        WebClient.Builder builder = WebClient.builder();

        int index = 0;

        for (int i = 0; i < 5; i++) {
            String catFact = builder.build()
                    .get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            store.put(index++, catFact);
        }
    }

    public String getStoreAsString() {
        String collect = String.join("\n", store.values());
        return collect;
    }
}
