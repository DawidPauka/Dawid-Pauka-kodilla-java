package com.kodilla.testing.library;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BookDirectoryTestSuite {
    private LibraryDatabase libraryDatabaseMock;
    private BookLibrary bookLibrary;

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Before
    public void before() {
        // Given
        libraryDatabaseMock = mock(LibraryDatabase.class);
        bookLibrary = new BookLibrary(libraryDatabaseMock);
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition_INTERFEJS("Secret"))
                .thenReturn(resultListOfBooks);
        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition_KLASA("Secret");
        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition_INTERFEJS(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition_INTERFEJS("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition_INTERFEJS("FourtyBooks"))
                .thenReturn(resultListOf40Books);
        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition_KLASA("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition_KLASA("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition_KLASA("FourtyBooks");
        // Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition_INTERFEJS(anyString()))
                .thenReturn(resultListOf10Books);
        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition_KLASA("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition_INTERFEJS(anyString());
    }

    @Test
    public void testListBooksInHandsOf0Books() {
        // Given
        LibraryUser libraryUser = new LibraryUser("Name", "LastName", "88112233445");
        when(libraryDatabaseMock.listBooksInHandsOf_INTERFEJS(any(LibraryUser.class)))
                .thenReturn(new ArrayList<>());
        // When
        List<Book> theListOfBorrowedBooks = bookLibrary.listBooksInHandsOf_KLASA(libraryUser);
        // Then
        assertEquals(0, theListOfBorrowedBooks.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf_INTERFEJS(libraryUser);
    }

    @Test
    public void testListBooksInHandsOf1Book() {
        // Given
        LibraryUser libraryUser = new LibraryUser("Name", "LastName", "88112233445");
        when(libraryDatabaseMock.listBooksInHandsOf_INTERFEJS(any(LibraryUser.class)))
                .thenReturn(generateListOfNBooks(1));
        // When
        List<Book> theListOfBorrowedBooks = bookLibrary.listBooksInHandsOf_KLASA(libraryUser);
        // Then
        assertEquals(1, theListOfBorrowedBooks.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf_INTERFEJS(libraryUser);
    }

    @Test
    public void testListBooksInHandsOf5Books() {
        // Given
        LibraryUser libraryUser = new LibraryUser("Name", "LastName", "88112233445");
        when(libraryDatabaseMock.listBooksInHandsOf_INTERFEJS(any(LibraryUser.class)))
                .thenReturn(generateListOfNBooks(5));
        // When
        List<Book> theListOfBorrowedBooks = bookLibrary.listBooksInHandsOf_KLASA(libraryUser);
        // Then
        assertEquals(5, theListOfBorrowedBooks.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf_INTERFEJS(libraryUser);
    }
}