package restapi.demo.utils.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import restapi.demo.utils.Post;

@Data
public class CommentResponseDTO {


    private Long id;

    private String name;

    private String email;

    private String body;

    @JsonIgnore
    private Post post;

    
}
