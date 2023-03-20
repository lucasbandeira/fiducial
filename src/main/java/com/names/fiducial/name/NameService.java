package com.names.fiducial.name;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class NameService {
    private NameRepository repository;

    public NameService(NameRepository repository) {
        super();
        this.repository = repository;
    }

    public Optional<Map<String, Object>> getNames(final Pageable pageable) {
        return Optional.of(NameDTOResponse.convertToResponse(repository.getNames(pageable)));
    }

    public boolean existByName(final String name) {
        return repository.existsByName(name);
    }

    public void create(Set<Name> names) {
        names.stream()
                .filter(name -> !existByName(name.getName()))
                .forEach(name -> repository.save(name));
    }
}
