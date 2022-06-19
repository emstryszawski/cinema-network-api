package pl.edu.pjatk.cinemanetworkapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Repertoire;
import pl.edu.pjatk.cinemanetworkapi.service.RepertoireService;

import java.util.List;

@RestController
@RequestMapping("/repertoires")
public class RepertoireController {
    private final RepertoireService repertoireService;

    @Autowired
    public RepertoireController(RepertoireService repertoireService) {
        this.repertoireService = repertoireService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Repertoire>> getAllRepertoires() {
        return ResponseEntity.ok(repertoireService.getAllRepertoires());
    }
}
