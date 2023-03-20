package com.names.fiducial.name;

import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class NameDTOResponse {
    static public Map<String, Object> convertToResponse(final Page<Name> namesPage) {
        Map<String,Object> response = new HashMap<>();

        response.put("names", namesPage.getContent().stream().map(Name::getName).collect(Collectors.toList()));
        response.put("current-page", namesPage.getNumber());
        response.put("total-items", namesPage.getTotalElements());
        response.put("total-pages", namesPage.getTotalPages());

        return response;
    }
}
