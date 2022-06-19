package pl.edu.pjatk.cinemanetworkapi.service;

import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class CorrelationService {
    private final LinkedList<Long> correlationIds = new LinkedList<>();

    public Long getCorrelationId() {
        if (!correlationIds.isEmpty()) {
            correlationIds.add(correlationIds.getLast() + 1);
            return correlationIds.getLast() + 1;
        } else {
            correlationIds.add(1L);
            return 1L;
        }
    }
}
