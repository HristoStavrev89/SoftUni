package com.softuni.springdataintroexercise.services.impl;

import com.softuni.springdataintroexercise.constants.GlobalConstants;
import com.softuni.springdataintroexercise.entities.*;
import com.softuni.springdataintroexercise.repositories.BookRepository;
import com.softuni.springdataintroexercise.services.AuthorService;
import com.softuni.springdataintroexercise.services.BookService;
import com.softuni.springdataintroexercise.services.CategoryService;
import com.softuni.springdataintroexercise.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.fileUtil = fileUtil;
    }


    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] fileContent = this.fileUtil
                .readFileContent(GlobalConstants.BOOKS_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(row -> {
                    String[] params = row.split("\\s+");

                    Author author = this.authorService.geRandomAuthor();

                    EditionType editionType = EditionType.values()[Integer.parseInt(params[0])];

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                    LocalDate releasedDate = LocalDate.parse(params[1], formatter);

                    int copies = Integer.parseInt(params[2]);

                    BigDecimal price = new BigDecimal(params[3]);

                    AgeRestriction ageRestriction = AgeRestriction
                            .values()[Integer.parseInt(params[4])];

                    String title = this.getTitle(params);


                    Set<Category> categories = this.categoryService.getRandomCategories();


                    Book book = new Book();

                    book.setAuthor(author);
                    book.setEditionType(editionType);
                    book.setReleaseDate(releasedDate);
                    book.setCopies(copies);
                    book.setPrice(price);
                    book.setAgeRestriction(ageRestriction);
                    book.setTitle(title);
                    book.setCategories(categories);

                    this.bookRepository.saveAndFlush(book);
                });

    }

    @Override
    public List<String> findAllTitles(String year) {

        LocalDate releasedDate = LocalDate.parse("31/12/" + year, DateTimeFormatter.ofPattern("d/M/yyyy"));

        return this.bookRepository
                .findAllByReleaseDateAfter(releasedDate)
                .stream()
                .map(b -> b.getTitle())
                .collect(Collectors.toList());

    }

    @Override
    public List<String> findAllAuthors(String year) {
        LocalDate releasedDate = LocalDate.parse("1/1/" + year, DateTimeFormatter.ofPattern("d/M/yyyy"));

        return this.bookRepository
                .findAllByReleaseDateBefore(releasedDate)
                .stream()
                .map(b -> String.format("%s %s"
                        , b.getAuthor().getFirstName()
                        , b.getAuthor().getLastName()
                )).collect(Collectors.toList());
    }

    private String getTitle(String[] params) {
        StringBuilder sb = new StringBuilder();

        for (int i = 5; i < params.length; i++) {
            sb.append(params[i])
                    .append(" ");
        }


        return sb.toString().trim();
    }


    @Override
    public List<Book> findAllBooksByAuthorNames(String firstName, String lastName) {
        return this.bookRepository
                .findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDesc(firstName, lastName);
    }

    @Override
    public List<Book> findBooksByAgeRestriction(String ageRestriction) {
        return this.bookRepository.findAllByAgeRestriction(AgeRestriction.valueOf(ageRestriction.toUpperCase()));
    }

    @Override
    public List<Book> findBooksByEditionTypeAndCopiesCount(String editionType, int copies) {
        return this.bookRepository
                .findAllByEditionTypeAndCopiesLessThan(EditionType.valueOf(editionType.toUpperCase()), copies);
    }

    @Override
    public List<Book> findBooksByPrice(double lowerThan, double higherThan) {
        BigDecimal lower = BigDecimal.valueOf(lowerThan);
        BigDecimal higher = BigDecimal.valueOf(higherThan);

        return this.bookRepository
                .findAllByPriceIsLessThanOrPriceIsGreaterThan(lower, higher);
    }

    @Override
    public List<Book> findBooksByReleaseDateIsNotInYear(int year) {
        LocalDate before = LocalDate.of(year, 1, 1);
        LocalDate after = LocalDate.of(year, 12, 31);
        return this.bookRepository
                .findAllByReleaseDateBeforeOrReleaseDateAfter(before, after);
    }

    @Override
    public List<Book> findBooksBeforeReleasedDate(LocalDate date) {

       return this.bookRepository
                .findAllByReleaseDateBefore(date);
    }

    @Override
    public List<Book> findBooksTitleContain(String str) {
        return this.bookRepository
                .findAllByTitleContains(str);
    }

    @Override
    public List<Book> findBooksWithTitleLongerThan(int length) {
        return this.bookRepository
                .findAllByTitleIsLonger(length);
    }

    @Override
    public Book findBookByTitle(String title) {
        return this.bookRepository
                .findBookByTitle(title);
    }

    @Override
    public List<Book> findAllBooksAfterGivenDate(LocalDate localDate) {
        return this.bookRepository
                .findAllByReleaseDateAfter(localDate);
    }

    @Override
    public int updateBooksCopiesAfterDate(String date, int copies) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
       return this.bookRepository
                .updateBooksCopiesAfterGivenDate(localDate, copies);
    }

    @Override
    public int deleteBooksWithCopiesLessThan(int copies) {
        return this.bookRepository
                .deleteBookByCopiesLessThan(copies);
    }


}
