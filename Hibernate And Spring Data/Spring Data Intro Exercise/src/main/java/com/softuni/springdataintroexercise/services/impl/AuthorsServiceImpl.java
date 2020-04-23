package com.softuni.springdataintroexercise.services.impl;

import com.softuni.springdataintroexercise.constants.GlobalConstants;
import com.softuni.springdataintroexercise.entities.Author;
import com.softuni.springdataintroexercise.entities.Category;
import com.softuni.springdataintroexercise.repositories.AuthorRepository;
import com.softuni.springdataintroexercise.services.AuthorService;
import com.softuni.springdataintroexercise.services.CategoryService;
import com.softuni.springdataintroexercise.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;

@Service
@Transactional
public class AuthorsServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;


    @Autowired
    public AuthorsServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil, CategoryService categoryService) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorRepository.count() != 0) {
            return;
        }

        String[] fileContent = this.fileUtil
                .readFileContent(GlobalConstants.AUTHOR_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r -> {
                    String[] params = r.split("\\s+");
                    Author author = new Author(params[0], params[1]);

                    this.authorRepository.saveAndFlush(author);
                });
    }

    @Override
    public List<Author> getAllAuthors() {
        return this.authorRepository
                .getAuthors();

    }

    @Override
    public int getAllAuthorsCount() {
       return (int) this.authorRepository.count();
    }

    @Override
    public Author findAuthorById(long id) {
        return this.authorRepository.getOne(id);
    }

    @Override
    public boolean isAuthorExistByNames(String firstName, String lastName) {

        return this.authorRepository
                .existsByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Set<Author> getAllAuthorsTest() {
        return this.authorRepository
                .findAuthorsByBooksIsNotNullOrderByBooksDesc();
    }

    @Override
    public Author geRandomAuthor() {
        Random random = new Random();

        long randomId = random.nextInt(getAllAuthorsCount()) + 1;

        return findAuthorById(randomId);
    }


    @Override
    public List<Author> findAuthorsFirstNamesEndWith(String endWith) {
       return this.authorRepository
                .findAllByFirstNameEndsWith(endWith);
    }

    @Override
    public List<Author> findAllByLastNameStartsWith(String endWith) {
        return this.authorRepository
                .findAllByLastNameStartsWith(endWith);
    }

    @Override
    public Author getAuthorByNames(String firstName, String lastName) {
        return this.authorRepository
                .getAuthorByFirstNameAndLastName(firstName, lastName);
    }
}
