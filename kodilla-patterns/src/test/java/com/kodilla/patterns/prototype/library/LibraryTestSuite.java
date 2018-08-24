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
        Assert.assertEquals(2, library.getBooks().size());
        Assert.assertEquals(2, clonedLibrary.getBooks().size());
        Assert.assertEquals(3, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(library.getBooks().size(),clonedLibrary.getBooks().size());
        Assert.assertNotEquals(library.getBooks().size(),deepClonedLibrary.getBooks().size());
    }


}