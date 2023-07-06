package restapi.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
