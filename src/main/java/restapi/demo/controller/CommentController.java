package restapi.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import restapi.demo.dto.CommentDTO;
import restapi.demo.service.CommentService;
import restapi.demo.utils.Comment;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Comment>> getAlluser() {
        return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestBody CommentDTO commentDTO) {
        return new ResponseEntity<>(commentService.saveComment(commentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CommentDTO>> findById(@RequestParam("id") Long id,
            @RequestBody CommentDTO commentDTO) {
        return new ResponseEntity<>(commentService.update(commentDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteComment(@RequestParam("idToDelete") Long id) {
        return new ResponseEntity<>(commentService.deleteComment(id), HttpStatus.OK);
    }

}
