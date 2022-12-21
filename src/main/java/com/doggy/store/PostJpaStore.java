package com.doggy.store;

import com.doggy.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostJpaStore implements PostStore {

    private final PostJpaRepository postJpaRepository;

    public PostJpaStore(PostJpaRepository postJpaRepository) {
        this.postJpaRepository = postJpaRepository;
    }

    @Override
    public List<Post> getAll() {
        return postJpaRepository.findAll().stream().map(PostEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public Post get(Integer id) {
        return postJpaRepository.findById(id).get().toDomain();
    }

    @Override
    public Post add(Post post) {
        return postJpaRepository.save(new PostEntity(post)).toDomain();
    }

    @Override
    public Post update(Post post) {
        return postJpaRepository.save(new PostEntity(post)).toDomain();
    }

    @Override
    public void delete(Integer id) {
        postJpaRepository.deleteById(id);
    }
}
