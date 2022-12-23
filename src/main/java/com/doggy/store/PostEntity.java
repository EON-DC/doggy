package com.doggy.store;


import com.doggy.domain.Post;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class PostEntity {

    @Id
    private Integer id;
    private Integer userId;
    private String title;
    private String body;

    public PostEntity() {
    }

    public PostEntity(Post post) {
        BeanUtils.copyProperties(post, this);
    }

    public Post toDomain() {
        Post post = new Post();
        BeanUtils.copyProperties(this, post);
        return post;
    }

}
