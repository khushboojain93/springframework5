package com.infogain.springframework5.bootstrap;

import com.infogain.springframework5.domain.Author;
import com.infogain.springframework5.domain.Book;
import com.infogain.springframework5.repositories.AuthorRepository;
import com.infogain.springframework5.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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


    }
}
