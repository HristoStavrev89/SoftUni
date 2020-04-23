package com.softuni.springdataintroexercise.repositories;

import com.softuni.springdataintroexercise.entities.AgeRestriction;
import com.softuni.springdataintroexercise.entities.Author;
import com.softuni.springdataintroexercise.entities.Book;
import com.softuni.springdataintroexercise.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDesc(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int count);

    List<Book> findAllByPriceIsLessThanOrPriceIsGreaterThan(BigDecimal lowerThan, BigDecimal higherThan);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findAllByTitleContains(String containStr);

    @Query("SELECT b FROM Book AS b WHERE LENGTH(b.title) > :num")
    List<Book> findAllByTitleIsLonger(@Param("num")int number);

    Book findBookByTitle(String title);


    @Modifying
    @Query("UPDATE Book AS b SET b.copies = b.copies + ?2 WHERE b.releaseDate > ?1")
    int updateBooksCopiesAfterGivenDate(LocalDate localDate, int copies);


    @Modifying
    //@Query("DELETE FROM Book AS b WHERE b.copies < ?1")
    int deleteBookByCopiesLessThan(int copies);
}
