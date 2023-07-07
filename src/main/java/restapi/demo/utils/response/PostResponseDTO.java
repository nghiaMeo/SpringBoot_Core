package restapi.demo.utils.response;

import java.util.Set;

import lombok.Data;

@Data
public class PostResponseDTO {

    private Long id;
    private String title;

    private String description;

    private String content;

    private Set<CommentResponseDTO> comments;
}
