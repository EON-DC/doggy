package com.doggy.store;

import com.doggy.domain.Post;

import java.util.List;

public interface PostStore {

    List<Post> getAll();

    Post get(Integer id);

    Post add(Post post);

    Post update(Post post);

    void delete(Integer id);
}
