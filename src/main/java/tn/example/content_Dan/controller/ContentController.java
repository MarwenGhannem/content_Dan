package tn.example.content_Dan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tn.example.content_Dan.model.Content;
import tn.example.content_Dan.model.Status;
import tn.example.content_Dan.model.Type;
import tn.example.content_Dan.repository.ContentRepository;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/{id}")
    public Optional<Content> getContentById(@PathVariable Integer id){
        return Optional.ofNullable(contentRepository.findById(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT,"Content not found"));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addContent(@RequestBody Content content){
        contentRepository.save(content);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateContent(@RequestBody Content content,@PathVariable Integer id){
        if (!contentRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"Content not found");
        }
        contentRepository.save(content);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteContentById(@PathVariable Integer id){
        contentRepository.deleteById(id);
    }
    @GetMapping("/type/{type}")
    public List<Content> contentByType(@PathVariable String type){
        return contentRepository.findAllByContentType(type.toUpperCase());
    }

    @GetMapping("/status/{status}")
    public List<Content> contentByStatus(@PathVariable Status status){
        return contentRepository.listByStatus(status);
    }

    @PutMapping("query/{id}")
    public void updateContentQuery(@PathVariable Integer id, @RequestBody Content content){
        contentRepository.updateContent(content.title(), id);
    }

}
