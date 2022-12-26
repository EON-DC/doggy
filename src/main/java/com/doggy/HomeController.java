package com.doggy;

import com.doggy.domain.Post;
import com.doggy.mapper.PlaceHolderGrep;
import com.doggy.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    private PlaceHolderGrep placeHolderGrep;
    private PostService postService;

    public HomeController(PlaceHolderGrep placeHolderGrep, PostService postService) {
        this.placeHolderGrep = placeHolderGrep;
        this.postService = postService;
    }

    @GetMapping
    public List<Post> homeView() {
        return postService.getAll();
    }

    @GetMapping(path = "{id}")
    public Post getPost(@PathVariable Integer id) {
        return postService.get(id);
    }

    @PostMapping
    public Post addPost(@RequestBody Post post) {
        return postService.add(post);
    }
}
