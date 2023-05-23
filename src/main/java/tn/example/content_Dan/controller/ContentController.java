package tn.example.content_Dan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.example.content_Dan.model.Content;
import tn.example.content_Dan.repository.ContentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentRepository contentRepository;

    public ContentController(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }
    @GetMapping
    public List<Content> getAllContent(){
        return contentRepository.findAll();
    }

}
