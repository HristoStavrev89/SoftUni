package com.softuni.springdataintroexercise.repositories;

import com.softuni.springdataintroexercise.entities.Author;
import com.softuni.springdataintroexercise.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author AS a ORDER BY a.books.size DESC")
    List<Author> getAuthors();

    //Same function without query
    Set<Author> findAuthorsByBooksIsNotNullOrderByBooksDesc();

    List<Author> findAllByFirstNameEndsWith(String endWith);

    boolean existsByFirstNameAndLastName(String firstName, String lastName);

    List<Author> findAllByLastNameStartsWith(String endWith);

    Author getAuthorByFirstNameAndLastName(String firstName, String lastName);

}
