package pl.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.exception.PersonAlreadyExistsException;
import pl.exception.PersonNotFoundException;
import pl.model.Person;
import pl.repository.PersonRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonService {



private final PersonRepository personRepository;

    public Person getPerson(final UUID personUUID) {

        return personRepository.findByUuid(personUUID).orElseThrow(PersonNotFoundException::new);

        public List<Person> getPersons(){
            return personRepository.findAll();
        }
        public void save (Person person){
           if ()personRepository.findByEmail(person.getEmail()).isPresent(){
               throw new PersonAlreadyExistsException;
            }
           person.setPersonUuid(UUID.randomUUID());
           person.getAddress().setAddressUuid(UUID.randomUUID());
            personRepository.save(person);

        }

        public void editPerson(final UUID personUUID,final Person person) {
           final Person personFromDb = getPerson(personUUID);

            personFromDb.setEmail(person.getEmail());
            personFromDb.setName(person.getName());
            personFromDb.setSurname(person.getSurname());
            personFromDb.setTelephone(person.getTelephone());

            personFromDb.getAddress().setCity(person.getAddress().getCity());
            personFromDb.getAddress().setStreet(person.getAddress().getStreet());
            personFromDb.getAddress().setStreetNumber(person.getAddress().getStreetNumber());
            personFromDb.getAddress().setHomeNumber(person.getAddress().getHomeNumber());

            personRepository.save(person);

        }


        public void delete(final UUID personUUID){
            checkIsPersonExists( personUUID );
            final Person person = getPerson(personUUID);
            personRepository.remove(personUUID);
            }
        }
        private void checkIsPersonExists(UUID personUUID) {
            if (!personRepository.findByUuid( personUUID ).isPresent()) {
                throw new PersonNotFoundException();
            }
        }


    }




}
