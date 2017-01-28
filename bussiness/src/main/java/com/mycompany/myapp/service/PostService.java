package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.PostDTO;
import java.util.List;

/**
 * Service Interface for managing Post.
 */
public interface PostService {

    /**
     * Save a post.
     *
     * @param postDTO the entity to save
     * @return the persisted entity
     */
    PostDTO save(PostDTO postDTO);

    /**
     *  Get all the posts.
     *  
     *  @return the list of entities
     */
    List<PostDTO> findAll();

    /**
     *  Get the "id" post.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PostDTO findOne(Long id);

    /**
     *  Delete the "id" post.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
