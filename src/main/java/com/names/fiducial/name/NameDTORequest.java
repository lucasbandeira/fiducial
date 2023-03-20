package com.names.fiducial.name;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NameDTORequest {

    @JsonProperty("names")
    @NotBlank
    private List<String> names;

    @JsonCreator
    public NameDTORequest(@NotBlank final List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    public Set<Name> convetToName() {
        return new HashSet<>(names)
                .stream()
                .map(Name::new)
                .collect(Collectors.toSet());
    }
}
