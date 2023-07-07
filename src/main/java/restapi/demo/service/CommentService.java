package restapi.demo.service;

import java.util.List;
import java.util.Optional;

import restapi.demo.dto.CommentDTO;
import restapi.demo.utils.response.CommentResponseDTO;

public interface CommentService {
    List<CommentResponseDTO> getAllComments();

    Optional<CommentResponseDTO> findAllId(Long id);

    CommentResponseDTO saveComment(CommentDTO commentDTO);

    CommentResponseDTO update(CommentDTO commentDTO, Long id);

    String deleteComment(Long id);
}
