package restapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restapi.demo.utils.Comment;

@Repository
public interface CommentRespository extends JpaRepository<Comment, Long> {

}
