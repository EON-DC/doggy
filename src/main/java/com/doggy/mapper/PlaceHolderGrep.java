package com.doggy.mapper;

import com.doggy.service.PostService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlaceHolderGrep {

    private PostService postService;


    private String url = "";


    public PlaceHolderGrep(PostService postService) {
//        this.postService = postService;
//        WebClient.Builder builder = WebClient.builder();
//
//        List<Post> response = Objects.requireNonNull(builder.build()
//                .get()
//                .uri(url)
//                .retrieve()
//                .bodyToMono(new ParameterizedTypeReference<List<Post>>() {
//                }).block());
//
//        for (Post post : response) {
//            //store.put(post.getId(), post);
//            postService.add(post);
//        }
    }
}
