package pl.mg.guru.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.mg.guru.model.Author;
import pl.mg.guru.model.Book;
import pl.mg.guru.model.Publisher;
import pl.mg.guru.repositories.AuthorRepository;
import pl.mg.guru.repositories.BookRepository;
import pl.mg.guru.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher harper = new Publisher("Harper Colins");
        publisherRepository.save(harper);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);


        authorRepository.save(eric);
        bookRepository.save(ddd);

        Publisher worx = new Publisher("Worx");
        publisherRepository.save(worx);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "234444", worx);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
