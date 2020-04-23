package com.softuni.springdataintroexercise.services;

import com.softuni.springdataintroexercise.entities.Author;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface AuthorService {

    void seedAuthors() throws IOException;

    int getAllAuthorsCount();

    Author findAuthorById(long id);

    List<Author> getAllAuthors();

    boolean isAuthorExistByNames(String firstName, String lastName);

    Set<Author> getAllAuthorsTest();

   Author geRandomAuthor();

   List<Author> findAuthorsFirstNamesEndWith(String endWith);

   List<Author> findAllByLastNameStartsWith(String endWith);

   Author getAuthorByNames(String firstName, String lastName);
}
