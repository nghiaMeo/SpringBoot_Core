package restapi.demo.service;

import java.util.List;
import java.util.Optional;

import restapi.demo.dto.PostDTO;
import restapi.demo.utils.response.PostResponseDTO;

public interface PostService {
    List<PostResponseDTO> getAllPost();

    Optional<PostResponseDTO> findById(Long id);

    PostResponseDTO savePost(PostDTO postDTO);

    PostResponseDTO updatePost(PostDTO postDTO, Long id);

    String deletePost(Long id);
}
