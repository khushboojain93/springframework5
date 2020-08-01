package com.infogain.springframework5.bootstrap;

import com.infogain.springframework5.domain.Author;
import com.infogain.springframework5.domain.Book;
import com.infogain.springframework5.domain.Publisher;
import com.infogain.springframework5.repositories.AuthorRepository;
import com.infogain.springframework5.repositories.BookRepository;
import com.infogain.springframework5.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

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

        Author author1=new Author("Eric", "Evans");
        Book book1=new Book("Domain Driven Design", "123123");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        authorRepository.save(author1);
        bookRepository.save(book1);

        Author author2=new Author("Nicholas","Sparks");
        Book book2=new Book("TFIOS","4515164");

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        authorRepository.save(author2);
        bookRepository.save(book2);
        System.out.println("Started in BootStrap");
        System.out.println("No of books: "+bookRepository.count());

        Set<Book> bookSet=new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);

        Publisher publisher=new Publisher();
        publisher.setName("Assignment-publisher");
        publisher.setAddressLine1("Publisher-address");
        publisher.setCity("seattle");
        publisher.setState("United States");
        publisher.setZip("Publisher-zip");
        //publisher.getBooks().add(book1);
        //publisher.getBooks().add(book2);
        publisher.setBooks(bookSet);

        publisherRepository.save(publisher);

        System.out.println("No of publishers: "+publisherRepository.count());
        System.out.println("No of books published by publisher: "+publisher.getBooks().size());
        

        book1.setPublisher(publisher);
        book2.setPublisher(publisher);

        System.out.println("Publisher for "+book1.getTitle()+" is : "+book1.getPublisher().getName());
        System.out.println("Publisher for "+book2.getTitle()+" is : "+book2.getPublisher().getName());




    }
}
