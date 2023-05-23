package tn.example.content_Dan.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import tn.example.content_Dan.model.Content;

@Repository
public interface ContentRepository extends ListCrudRepository<Content, Integer> {

}
