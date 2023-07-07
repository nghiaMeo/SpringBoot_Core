package restapi.demo.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import restapi.demo.dto.PostDTO;
import restapi.demo.repository.PostRepository;
import restapi.demo.service.PostService;
import restapi.demo.utils.Post;
import restapi.demo.utils.response.PostResponseDTO;

@Service
@RequiredArgsConstructor // meaning ????

public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<PostResponseDTO> getAllPost() {
        return postRepository.findAll().stream();
    }

    @Override
    public Optional<PostResponseDTO> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public PostResponseDTO savePost(PostDTO postDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'savePost'");
    }

    @Override
    public PostResponseDTO updatePost(PostDTO postDTO, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePost'");
    }

    @Override
    public String deletePost(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePost'");
    }


    private PostResponseDTO mappertoPostDTO(Post entity){
        PostResponseDTO postResponseDTO = new PostResponseDTO();
        postResponseDTO.setId(entity.getId());
        postResponseDTO.setTitle(entity.getTitle());
        postResponseDTO.setDescription(entity.getDescription());
        postResponseDTO.setContent(entity.getContent());
        postResponseDTO.setComments(entity.getComments().stream().map(c -> mappertoCommentDTO(c)).collect(Collectors.toSet()));
        return postResponseDTO;

    }

}
