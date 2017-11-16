package com.zhai.service.impl;

import com.zhai.entity.book.Book;
import com.zhai.mapping.BookMapper;
import com.zhai.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/10/31.
 */
@Service
public class BookService implements IBookService{
    @Autowired
    private BookMapper bookMapper;

    public BookMapper getBookMapper() {
        return bookMapper;
    }

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public Book selectBook(int bookId){
        Book book = bookMapper.selectBookById(bookId);
        return book;
    }
}
