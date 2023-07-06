package restapi.demo.service;

import java.util.List;
import java.util.Optional;

import restapi.demo.dto.CommentDTO;
import restapi.demo.utils.Comment;

public interface CommentService {
    List<Comment> getAllComments();

    Optional<Comment> findAllId(Long id);

    Comment saveComment(CommentDTO commentDTO);
}
