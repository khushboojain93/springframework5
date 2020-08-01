package com.infogain.springframework5.bootstrap;

import com.infogain.springframework5.domain.Author;
import com.infogain.springframework5.domain.Book;
import com.infogain.springframework5.domain.Publisher;
import com.infogain.springframework5.repositories.AuthorRepository;
import com.infogain.springframework5.repositories.BookRepository;
import com.infogain.springframework5.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric=new Author("Eric", "Evans");
        Book ericBook=new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ericBook);
        ericBook.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ericBook);

        System.out.println("Started in BootStrap");
        System.out.println("No of books: "+bookRepository.count());

        Publisher publisher=new Publisher();
        publisher.setName("Assignment-publisher");
        publisher.setAddressLine1("Publisher-address");
        publisher.setCity("seattle");
        publisher.setState("United States");
        publisher.setZip("Publisher-zip");

        publisherRepository.save(publisher);

        System.out.println("No of publishers: "+publisherRepository.count());


    }
}
