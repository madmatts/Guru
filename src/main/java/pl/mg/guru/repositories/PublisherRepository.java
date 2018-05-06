package pl.mg.guru.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mg.guru.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
