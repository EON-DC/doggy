package com.doggy.service;

import com.doggy.domain.Post;
import com.doggy.share.NameValueList;

import java.util.List;

public interface PostService {


    List<Post> getAll();

    Post get(Integer id);

    Post add(Post post);

    Post update(Integer id, NameValueList nameValueList);

    void delete(Integer id);


}
