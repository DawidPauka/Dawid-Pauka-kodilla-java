package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks()throws Exception{
        //Given
        Library library = new Library("Księgozbiór");
        Book book1 = new Book("Tytuł 1","Autor 1",LocalDate.of(1987,1,1));
        library.getBooks().add(book1);
        library.getBooks().add(new Book("Tytuł 2","Autor 2",LocalDate.of(2017,11,13)));
        library.getBooks().add(new Book("Tytuł 3","Autor 3",LocalDate.of(1999,7,22)));

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Płytko sklonowany Księgozbiór");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Głęboko sklonowany Księgozbiór");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book1);

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(2, library.getBooks().size());
        Assert.assertEquals(2, clonedLibrary.getBooks().size());
        Assert.assertEquals(3, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(library.getBooks().size(),clonedLibrary.getBooks().size());
        Assert.assertNotEquals(library.getBooks().size(),deepClonedLibrary.getBooks().size());
    }

    @Test
    public void testShallowCopy() {
        //Given
        Library library = new Library("Library number 1");
        Book book1 = new Book("title1", "author1", LocalDate.now().minusYears(1));
        Book book2 = new Book("title2", "author2", LocalDate.now().minusYears(2));
        library.getBooks().add(book1);
        library.getBooks().add(book2);

        //When
        Library cloneLibrary = null;
        try {
            cloneLibrary = library.shallowCopy();
            cloneLibrary.setName("Library number 2");
        } catch(CloneNotSupportedException e) {
            System.out.println(e);
        }

        library.getBooks().remove(book2);

        //Then
        System.out.println(library);
        System.out.println(cloneLibrary);
        Assert.assertEquals(1, library.getBooks().size());
        Assert.assertEquals(1, cloneLibrary.getBooks().size());
    }
    @Test
    public void testDeepCopy() {
        //Given
        Library library = new Library("Library number 1");
        Book book1 = new Book("title1", "author1", LocalDate.now().minusYears(1));
        Book book2 = new Book("title2", "author2", LocalDate.now().minusYears(2));
        library.getBooks().add(book1);
        library.getBooks().add(book2);

        //When
        Library deepCloneLibrary = null;
        try {
            deepCloneLibrary = library.deepCopy();
            deepCloneLibrary.setName("Library number 2");
        } catch(CloneNotSupportedException e) {
            System.out.println(e);
        }

        library.getBooks().remove(book2);

        //Then
        System.out.println(library);
        System.out.println(deepCloneLibrary);
        Assert.assertEquals(2, deepCloneLibrary.getBooks().size());
        Assert.assertNotEquals(library.getBooks(), deepCloneLibrary.getBooks());
    }
}

