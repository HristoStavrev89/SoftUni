package com.softuni.springdataintroexercise.controllers;

import com.softuni.springdataintroexercise.entities.Book;
import com.softuni.springdataintroexercise.services.AuthorService;
import com.softuni.springdataintroexercise.services.BookService;
import com.softuni.springdataintroexercise.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


@Controller
public class AppController implements CommandLineRunner {
    private Scanner scanner;

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {

        // seed data
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();

        scanner = new Scanner(System.in);

        //Spring Data Intro Exercises

        //Ex1
        //taskOne();

        //Ex2
        //taskTwo();

        //Ex3
        //taskThree();

        //Ex4
        //taskFour();



/***************************************************
        Exercises: Spring Data Advanced Quering
****************************************************/

        //Task 1 Books Titles by Age Restriction
        //findBooksByAgeRestriction();

        //Task 2 Golden Books
        //findGoldenEditionBooksWithLessThan500Copies();

        //Task 3 Books by Price
        //findBooksByGivenPrices();

        //Task 4 Not Released Books
        //findBooksNotReleasedInYear();

        //Task 5 Books Released Before Date
        //findBooksBeforeReleasedDate();

        //Task 6 Authors Search
        //findAuthorsWhoseFirstNameEndWith();

        //Task 7 Books Search
        //findBooksNamesContainGivenString();

        //Task 8 Book Titles Search
        //findBooksWhoseAuthorsLastNameEndsWith();

        //Task 9 Count Books
        //findBooksWhoseTitleIsLongerThan();

        //Task 10 Total Book Copies
        //findTotalNumberOfCopiesByAuthor();

        //Task 11 Reduced Book
        //findBookByGivenTitle();

        //Task 12 * Increase Books Copies
        //findBooksAfterGivenDateAndIncreaseCopies();

        //Task 13 * Remove Books
        //removeBooksWithCopiesLessThan();
    }

    private void removeBooksWithCopiesLessThan() {
        System.out.println("Enter number of copies.");
        int copiesInput = Integer.parseInt(scanner.nextLine());

        int booksCount = this.bookService
                .deleteBooksWithCopiesLessThan(copiesInput);

        System.out.println(String.format("%d books are removed.", booksCount));


    }

    private void findBooksAfterGivenDateAndIncreaseCopies() {

        System.out.println("Enter date.");
        String inputDate = scanner.nextLine();
        System.out.println("Enter number of copies.");
        int numOfCopies = Integer.parseInt(scanner.nextLine());

        int totalCountOfIncreasedBooksCopies = this.bookService
                .updateBooksCopiesAfterDate(inputDate, numOfCopies);

        System.out.println(totalCountOfIncreasedBooksCopies * numOfCopies);


    }

    private void findBookByGivenTitle() {
        //Hardcore value, why not...
        String title = "Things Fall Apart";
        Book book = this.bookService
                .findBookByTitle(title);

        System.out.println(String.format("%s %s %s %.2f"
                , book.getTitle()
                , book.getEditionType()
                , book.getAgeRestriction()
                , book.getPrice()));

        //Using souf (printf) instead sout (println) - the result is different.
//         the other type of fields are also printed, like the date..
//        System.out.printf("%s %s %s %.2f"
//                , book.getTitle()
//                , book.getEditionType()
//                , book.getAgeRestriction()
//                , book.getPrice());
    }

    private void findTotalNumberOfCopiesByAuthor() {
        try {
            //        String authorName = "Randy Graham";
            System.out.println("Enter author names.");
            String[] names = scanner.nextLine().split("\\s+");
            int count = this.bookService
                    .findAllBooksByAuthorNames(names[0], names[1])
                    .stream()
                    .mapToInt(Book::getCopies)
                    .sum();
            System.out.println(String.format("%s %s - %d", names[0], names[1], count));
        } catch (Exception e) {
            System.out.println("There is no books from the given author, or the given input is in wrong format.");
            // throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void findBooksWhoseTitleIsLongerThan() {
        try {
            int numLength = Integer.parseInt(scanner.nextLine());
            long count = this.bookService
                    .findBooksWithTitleLongerThan(numLength)
                    .stream()
                    .count();
            System.out.println(count);
            System.out.println(String.format("There are %d books with longer than %d symbols.", count, numLength));
        } catch (Exception e) {
            System.out.println("There are no books with title longer than the given number, or the given number is wrong format.");
            // throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void findBooksNamesContainGivenString() {
        try {
            System.out.println("Enter a string.");
            String str = scanner.nextLine();
            this.bookService
                    .findBooksTitleContain(str)
                    .forEach(b -> System.out.printf("%s%n", b.getTitle()));
        } catch (Exception e) {
            System.out.println("There is no books which titles contains the given string.");
            // throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void findBooksWhoseAuthorsLastNameEndsWith() {
        try {
            System.out.println("Enter a string.");
            String end = scanner.nextLine();
            this.authorService
                    .findAllByLastNameStartsWith(end)
                    .forEach(a -> {
                        a.getBooks().stream()
                                .forEach(b -> System.out.printf("%s (%s %s)%n"
                                        , b.getTitle()
                                        , b.getAuthor().getFirstName()
                                        , b.getAuthor().getLastName()));
                    });
        } catch (Exception e) {
            System.out.println("There is no Author with such last name end.");
            // throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void findAuthorsWhoseFirstNameEndWith() {

        try {
            System.out.println("Enter a string.");
            String end = scanner.nextLine();
            this.authorService
                    .findAuthorsFirstNamesEndWith(end)
                    .forEach(a -> System.out.printf("%s %s%n", a.getFirstName(), a.getLastName()));
        } catch (Exception e) {
            System.out.println("There is no Author with such first name end.");
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void findBooksBeforeReleasedDate() throws ParseException {
        try {
            System.out.println("Please enter a date in format: day-month-year");
            System.out.println("If the day or the month is less than 10 please put a zero in front of it.");
            System.out.println("Example: CORRECT -> 02-04-1992   /   WRONG -> 2-4-1992");
            String inputDate = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(inputDate, formatter);

            this.bookService
                    .findBooksBeforeReleasedDate(date)
                    .forEach(b -> System.out.printf("%s %s %.2f%n", b.getTitle(), b.getEditionType(), b.getPrice()));
        } catch (Exception e) {
            System.out.println("There is no books released after this year. Or the given input is wrong.");
            // throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void findBooksNotReleasedInYear() {
        try {
            System.out.println("Please enter a year.");
            int year = Integer.parseInt(scanner.nextLine());
            this.bookService.findBooksByReleaseDateIsNotInYear(year)
                    .forEach(b -> System.out.printf("%s%n", b.getTitle()));
        } catch (Exception e) {
            System.out.println("There is no books from this year.");
            // throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void findBooksByGivenPrices() {
        try {
            System.out.println("Price lower than ");
            double lower = Double.parseDouble(scanner.nextLine());
            System.out.println("Price higher than ");
            double higher = Double.parseDouble(scanner.nextLine());
            this.bookService
                    .findBooksByPrice(lower, higher)
                    .forEach(b -> System.out.printf("%s - $%.2f%n", b.getTitle(), b.getPrice()));
        } catch (Exception e) {
            System.out.println("Wrong price,there is no books with such a price, please try again.");
            // throw new IllegalArgumentException(Exception e.getMessage());
        }
    }

    private void findGoldenEditionBooksWithLessThan500Copies() {
        try {
            System.out.println("Please enter edition type. (gold, promo or normal)");
            String type = scanner.nextLine();
            System.out.println("Please enter a number of copies.");
            int copies = Integer.parseInt(scanner.nextLine());
            this.bookService
                    .findBooksByEditionTypeAndCopiesCount(type, copies)
                    .forEach(b -> System.out.printf("%s%n", b.getTitle()));
        } catch (Exception e) {
            System.out.println("Wrong edition type, try again.");
            // throw new IllegalArgumentException(e.getMessage());
        }

    }

    private void findBooksByAgeRestriction() {
        try {
            System.out.println("Please enter age restriction.");
            String restr = scanner.nextLine();
            this.bookService
                    .findBooksByAgeRestriction(restr)
                    .forEach(b -> System.out.printf("%s%n", b.getTitle()));
        } catch (Exception e) {
            System.out.println("There is no such a restriction, please try again.");
            //throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void taskFour() {
        System.out.println("Please enter author names, separate with space.");
        String[] names = scanner.nextLine().split("\\s+");
        if (!this.authorService.isAuthorExistByNames(names[0], names[1])) {
            System.out.println("This author does not exist.");
            return;
        }

        //It will be easier if we sort them from the repository with one simple query, but lets dont forget the collection sorts :)

        this.bookService
                .findAllBooksByAuthorNames(names[0], names[1])
                .stream()
                .sorted((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()))
                .forEach(b -> {
                    System.out.println(String.format("%s %s %d", b.getTitle(), b.getReleaseDate(), b.getCopies()));
                });
    }

    private void taskThree() {
        this.authorService
                .getAllAuthors()
                .forEach(a -> {
                    System.out.printf("%-10s %-10s %-10d%n"
                            , a.getFirstName()
                            , a.getLastName()
                            , a.getBooks().size()
                    );
                });
    }

    private void taskTwo() {
        try {
            System.out.println("Please enter four digits as year.");
            String year = this.scanner.nextLine();
            List<String> authors = this.bookService
                    .findAllAuthors(year);

            if (authors.size() != 0) {
                authors.forEach(System.out::println);
            } else {
                System.out.println("-".repeat(40));
                System.out.println("There is no author from this year.");
                System.out.println("-".repeat(40));
            }

        } catch (Exception e) {
            // throw new IllegalArgumentException(e.getMessage());
            System.out.println("!".repeat(30));
            System.out.println("There is no such a year. Please enter four digits as year.");
            System.out.println("!".repeat(30));
        }

    }

    private void taskOne() {

        try {
            System.out.println("Please enter four digits as year.");
            String year = this.scanner.nextLine();
            List<String> titles = this.bookService.findAllTitles(year);
            if (titles.size() != 0) {
                titles.forEach(System.out::println);
            } else {
                System.out.println("-".repeat(40));
                System.out.println("There is no book from this year.");
                System.out.println("-".repeat(40));
            }
        } catch (Exception e) {
            // throw new IllegalArgumentException(e.getMessage());
            System.out.println("!".repeat(30));
            System.out.println("There is no such a year. Please enter four digits as year.");
            System.out.println("!".repeat(30));
        }
    }

}
