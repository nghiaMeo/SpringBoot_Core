package restapi.demo.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import restapi.demo.dto.CommentDTO;
import restapi.demo.repository.CommentRespository;
import restapi.demo.service.CommentService;
import restapi.demo.utils.Comment;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRespository commentRespository;

    @Override
    public List<Comment> getAllComments() {
        return commentRespository.findAll();
    }

    @Override
    public Optional<Comment> findAllId(Long id) {
        return commentRespository.findById(id);
    }

    @Override
    public Comment saveComment(CommentDTO commentDTO) {
        Comment cmt = new Comment();
        cmt.setName(commentDTO.getName());
        cmt.setEmail(commentDTO.getEmail());
        cmt.setBody(commentDTO.getBody());
        // cmt.setPost(commentDTO.getPost());
        return commentRespository.save(cmt);
    }
}
