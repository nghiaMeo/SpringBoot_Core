package restapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restapi.demo.utils.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
