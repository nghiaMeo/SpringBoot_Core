package restapi.demo.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import restapi.demo.dto.CommentDTO;
import restapi.demo.repository.CommentRespository;
import restapi.demo.service.CommentService;
import restapi.demo.utils.Comment;
import restapi.demo.utils.response.CommentResponseDTO;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRespository commentRespository;

    @Override
    public List<CommentResponseDTO> getAllComments() {
        List<Comment> comments = commentRespository.findAll();
        return comments.stream().map(c -> mappertoCommentDTO(c)).collect(Collectors.toList());
    }

    @Override
    public Optional<CommentResponseDTO> findAllId(Long id) {
        Comment comment = commentRespository.findById(id).get();
        return Optional.of(mappertoCommentDTO(comment));
    }

    @Override
    public CommentResponseDTO saveComment(CommentDTO commentDTO) {
        Comment cmt = new Comment();
        cmt.setName(commentDTO.getName());
        cmt.setEmail(commentDTO.getEmail());
        cmt.setBody(commentDTO.getBody());
        // cmt.setPost(commentDTO.getPost());
        Comment savedComment = commentRespository.save(cmt);

        return mappertoCommentDTO(savedComment);
    }

    @Override
    public CommentResponseDTO update(CommentDTO commentDTO, Long id) {
        Comment comment = commentRespository.findById(id).get();
        comment.setEmail(commentDTO.getEmail());
        comment.setName(commentDTO.getName());
        comment.setBody(commentDTO.getBody());
        return mappertoCommentDTO(commentRespository.save(comment));
    }

    @Override
    public String deleteComment(Long id) {
        commentRespository.deleteById(id);
        return "Delete success";
    }

    public static CommentResponseDTO mappertoCommentDTO(Comment comment) {
        CommentResponseDTO commentResponseDTO = new CommentResponseDTO();
        commentResponseDTO.setId(comment.getId());
        commentResponseDTO.setBody(comment.getBody());
        commentResponseDTO.setEmail(comment.getEmail());
        commentResponseDTO.setName(comment.getName());
        commentResponseDTO.setPost(comment.getPost());
        return commentResponseDTO;
    }
}
