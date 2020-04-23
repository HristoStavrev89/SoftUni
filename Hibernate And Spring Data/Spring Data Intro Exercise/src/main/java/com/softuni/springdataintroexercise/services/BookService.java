package com.softuni.springdataintroexercise.services;

import com.softuni.springdataintroexercise.entities.AgeRestriction;
import com.softuni.springdataintroexercise.entities.Author;
import com.softuni.springdataintroexercise.entities.Book;
import com.softuni.springdataintroexercise.entities.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookService {
    void seedBooks() throws IOException;

    List<String> findAllTitles(String year);

    List<String> findAllAuthors(String year);

    List<Book> findAllBooksByAuthorNames(String firstName, String lastName);

    List<Book> findBooksByAgeRestriction(String restriction);

    List<Book> findBooksByEditionTypeAndCopiesCount(String editionType, int copies);

    List<Book> findBooksByPrice(double lowerThan, double higherThan);

    List<Book> findBooksByReleaseDateIsNotInYear(int year);

    List<Book> findBooksBeforeReleasedDate(LocalDate date);

    List<Book> findBooksTitleContain(String str);

    List<Book> findBooksWithTitleLongerThan(int length);

    Book findBookByTitle(String title);

    List<Book> findAllBooksAfterGivenDate(LocalDate localDate);

    int updateBooksCopiesAfterDate(String date, int copies);

    int deleteBooksWithCopiesLessThan(int copies);

}
