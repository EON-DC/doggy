package com.doggy.mapper;

import com.doggy.domain.Post;
import com.doggy.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Slf4j
public class PlaceHolderGrep {

    private PostService postService;


    private String url = "https://jsonplaceholder.typicode.com/posts";


    public PlaceHolderGrep(PostService postService) {
        this.postService = postService;
        WebClient.Builder builder = WebClient.builder();

        List<Post> response = Objects.requireNonNull(builder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Post>>() {
                }).block());

        for (Post post : response) {
            //store.put(post.getId(), post);
            postService.add(post);
        }
    }
}
