package pl.idea4u.entities.idea;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.idea4u.common.exceptions.IdeaNotFoundException;

import java.util.List;

@RestController
public class IdeaService {
    @Autowired
    IdeaRepository ideaRepository;

    @Autowired
    ObjectMapper objectMapper;

    ////////////////////// GET ////////////////////////
    @GetMapping("/idea")
    public ResponseEntity getAllIdeas() throws JsonProcessingException {
        List<Idea> ideas = ideaRepository.findAll();

        return ResponseEntity.ok(objectMapper.writeValueAsString(ideas));
    }

    @GetMapping("/idea/last-ten")
    public ResponseEntity getLastTenIdeas() throws JsonProcessingException {
        List<Idea> ideas = ideaRepository.findLastTenIdeas();

        return ResponseEntity.ok(objectMapper.writeValueAsString(ideas));
    }

    @GetMapping("/idea/top-ten")
    public ResponseEntity getTopTenIdeas() throws JsonProcessingException {
        List<Idea> ideas = ideaRepository.findTopTenIdeas();

        return ResponseEntity.ok(objectMapper.writeValueAsString(ideas));
    }

    @GetMapping("/idea/{id}")
    public ResponseEntity getIdea(@PathVariable Integer id) throws JsonProcessingException {
        Idea idea = ideaRepository.findById(id).orElseThrow(() -> new IdeaNotFoundException(id));

        return ResponseEntity.ok(objectMapper.writeValueAsString(idea));
    }

    @GetMapping("/idea/count")
    public ResponseEntity countIdeas() throws JsonProcessingException {
        int availableIdeas = ideaRepository.countIdeas();

        return ResponseEntity.ok(objectMapper.writeValueAsString(availableIdeas));
    }

    /////////////// POST //////////////////////
    @PostMapping("/idea")
    public ResponseEntity addIdea(@RequestBody Idea newIdea) {
        Idea savedIdea = ideaRepository.save(newIdea);

        return ResponseEntity.ok(savedIdea);
    }

}
