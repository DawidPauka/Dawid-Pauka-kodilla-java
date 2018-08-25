package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    @Test
    public void testShallowCopy() throws CloneNotSupportedException {
        //Given
        Library library = new Library("Library number 1");
        Book book1 = new Book("title1", "author1", LocalDate.now().minusYears(1));
        Book book2 = new Book("title2", "author2", LocalDate.now().minusYears(2));
        library.getBooks().add(book1);
        library.getBooks().add(book2);

        //When
        Library cloneLibrary = null;

        cloneLibrary = library.shallowCopy();
        cloneLibrary.setName("Library number 2");

        library.getBooks().remove(book2);

        //Then
        System.out.println(library);
        System.out.println(cloneLibrary);
        Assert.assertEquals(1, library.getBooks().size());
        Assert.assertEquals(1, cloneLibrary.getBooks().size());
    }
    @Test
    public void testDeepCopy() throws CloneNotSupportedException {
        //Given
        Library library = new Library("Library number 1");
        Book book1 = new Book("title1", "author1", LocalDate.now().minusYears(1));
        Book book2 = new Book("title2", "author2", LocalDate.now().minusYears(2));
        library.getBooks().add(book1);
        library.getBooks().add(book2);

        //When
        Library deepCloneLibrary = null;

        deepCloneLibrary = library.deepCopy();
        deepCloneLibrary.setName("Library number 3");

        library.getBooks().remove(book2);

        //Then
        System.out.println(library);
        System.out.println(deepCloneLibrary);
        Assert.assertEquals(2, deepCloneLibrary.getBooks().size());
        Assert.assertNotEquals(library.getBooks(), deepCloneLibrary.getBooks());
    }
}