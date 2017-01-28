package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.PostService;
import com.mycompany.myapp.domain.Post;
import com.mycompany.myapp.repository.PostRepository;
import com.mycompany.myapp.service.dto.PostDTO;
import com.mycompany.myapp.service.mapper.PostMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Post.
 */
@Service
@Transactional
public class PostServiceImpl implements PostService{

    private final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);
    
    @Inject
    private PostRepository postRepository;

    @Inject
    private PostMapper postMapper;

    /**
     * Save a post.
     *
     * @param postDTO the entity to save
     * @return the persisted entity
     */
    public PostDTO save(PostDTO postDTO) {
        log.debug("Request to save Post : {}", postDTO);
        Post post = postMapper.postDTOToPost(postDTO);
        post = postRepository.save(post);
        PostDTO result = postMapper.postToPostDTO(post);
        return result;
    }

    /**
     *  Get all the posts.
     *  
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<PostDTO> findAll() {
        log.debug("Request to get all Posts");
        List<PostDTO> result = postRepository.findAll().stream()
            .map(postMapper::postToPostDTO)
            .collect(Collectors.toCollection(LinkedList::new));

        return result;
    }

    /**
     *  Get one post by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public PostDTO findOne(Long id) {
        log.debug("Request to get Post : {}", id);
        Post post = postRepository.findOne(id);
        PostDTO postDTO = postMapper.postToPostDTO(post);
        return postDTO;
    }

    /**
     *  Delete the  post by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Post : {}", id);
        postRepository.delete(id);
    }
}
