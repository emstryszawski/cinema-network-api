package pl.edu.pjatk.cinemanetworkapi.service;


import org.springframework.stereotype.Service;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Repertoire;
import pl.edu.pjatk.cinemanetworkapi.model.repository.RepertoireRepository;

import java.util.List;

@Service
public class RepertoireService {
    private final RepertoireRepository repertoireRepository;

    public RepertoireService(RepertoireRepository repertoireRepository) {
        this.repertoireRepository = repertoireRepository;
    }

    public List<Repertoire> getAllRepertoires() {
        return repertoireRepository.findAll();
    }
}
