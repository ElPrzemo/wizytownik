package pl.repository;

import org.springframework.stereotype.Repository;
import pl.model.Adress;
import pl.model.Person;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long> {


    Optional <Person> findByUuid(final UUID personUUID);
    Optional <Person> findByEmail (final String email);
}
