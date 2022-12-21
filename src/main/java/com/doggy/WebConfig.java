package com.doggy;

import com.doggy.mapper.PlaceHolderGrep;
import com.doggy.service.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    private PostService postService;

    public WebConfig(PostService postService) {
        this.postService = postService;
    }

    @Bean
    public PlaceHolderGrep placeHolderGrep() {
        return new PlaceHolderGrep(postService);
    }
}
