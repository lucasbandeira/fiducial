package com.names.fiducial.name;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Tag(name="NameResource")
@RestController
@RequestMapping(value = "/fiducial/names", produces = "application/json;charset=UTF-8")
public class NameResource {
    @Autowired
    private NameService service;

    @Operation(summary = "List paginated names")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Names founds"),
            @ApiResponse(responseCode = "204", description = "No names founds")
    })
    @RequestMapping(path = "pageable", method = GET)
    public ResponseEntity<?> findAll(
            @Parameter(description = "Page number") @RequestParam(defaultValue = "0") final Integer page,
            @Parameter(description = "Max items per page") @RequestParam(defaultValue = "10") final Integer size) {
        Optional<Map<String, Object>> names = this.service.getNames(PageRequest.of(page, size));
        if (names.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.of(names);
    }

    @RequestMapping(path = "exist/{name}", method = GET)
    public boolean existByName(@PathVariable("name") final String name) {
        return this.service.existByName(name);
    }

    @Operation(summary = "Insert new names")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Pessoas criadas com sucesso", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request. The names cannot to be null or empty")
    })
    @Transactional
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody NameDTORequest names) {
        if(Objects.isNull(names.getNames()) || names.getNames().isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        this.service.create(names.convetToName());
        return ResponseEntity.status(CREATED).build();
    }


}
