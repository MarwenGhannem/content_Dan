package tn.example.content_Dan.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import tn.example.content_Dan.model.Content;
import tn.example.content_Dan.model.Status;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    List<Content> findAllByContentType(String type);
    @Query("""
            SELECT * FROM content 
            WHERE status = :status
            """)
    List<Content> listByStatus(@Param("status") Status status);

    @Modifying
    @Query("""
            update content set title = :title 
            where id = :id 
            """)
    void updateContent(@Param("title") String title, @Param("id") Integer id);
}
