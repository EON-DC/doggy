package com.doggy.service;

import com.doggy.domain.Post;
import com.doggy.share.NameValueList;
import com.doggy.store.PostStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostDefaultService implements PostService {

    private PostStore postStore;

    public PostDefaultService(PostStore postStore) {
        this.postStore = postStore;
    }

    @Override
    public List<Post> getAll() {
        return postStore.getAll();
    }

    @Override
    public Post get(Integer id) {
        return postStore.get(id);
    }

    @Override
    public Post add(Post post) {
        return postStore.add(post);
    }

    @Override
    public Post update(Integer id, NameValueList nameValueList) {
        Post findPost = postStore.get(id);
        findPost.setValues(nameValueList);
        return postStore.update(findPost);
    }

    @Override
    public void delete(Integer id) {
        postStore.delete(id);
    }
}
