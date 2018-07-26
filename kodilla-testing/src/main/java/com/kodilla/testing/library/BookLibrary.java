package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition_KLASA(String titleFragment) {
        List<Book> bookList = new ArrayList<>();
        if (titleFragment.length() < 3) {
            return bookList;
        }
        List<Book> resultList = libraryDatabase.listBooksWithCondition_INTERFEJS(titleFragment);
        if (resultList.size() > 20) {
            return bookList;
        }
        bookList = resultList;
        return bookList;
    }

    public List<Book> listBooksInHandsOf_KLASA(LibraryUser libraryUser) {
        return libraryDatabase.listBooksInHandsOf_INTERFEJS(libraryUser);
    }
}