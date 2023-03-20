package com.names.fiducial.name;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

public class NameServiceTest {
    @Test
    void existNameTest() {
        NameRepository repository = Mockito.mock(NameRepository.class);

        NameService service = new NameService(repository);
        Mockito.when(repository.existsByName("Lucas")).thenReturn(true);

        Assertions.assertEquals(true, service.existByName("Lucas"));
    }

    @Test
    void noExistNameTest() {
        NameRepository repository = Mockito.mock(NameRepository.class);

        NameService service = new NameService(repository);
        Mockito.when(repository.existsByName("Sandra")).thenReturn(false);

        Assertions.assertEquals(false, service.existByName("Sandra"));
    }

    @Test
    void createNameTest() {
        NameRepository repository = Mockito.mock(NameRepository.class);

        NameService service = new NameService(repository);

        Mockito.when(repository.existsByName("Ju")).thenReturn(false);
        Mockito.when(repository.existsByName("Jess")).thenReturn(true);

        Name ju = new Name("Ju");
        Name jess = new Name("Jess");
        Set<Name> names = Set.of(ju, jess);
        service.create(names);

        Mockito.verify(repository, Mockito.times(1)).save(ju);
        Mockito.verify(repository, Mockito.never()).save(jess);
    }
}
