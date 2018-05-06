package pl.mg.guru.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mg.guru.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
