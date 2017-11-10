package com.zhai.book.service;

import com.zhai.book.domin.Book;

/**
 * Created by admin on 2017/11/9.
 */
public interface IBookService {
    public Book selectBookById(int bookId);
}
