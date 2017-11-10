package com.zhai.book.service.impl;

import com.zhai.book.dao.BookDao;
import com.zhai.book.domin.Book;
import com.zhai.book.service.IBookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by admin on 2017/10/31.
 */
@Service
@Transactional
public class BookService implements IBookService{
    @Resource
    private BookDao bookDao;
    public Book selectBookById(int bookId){
        System.out.println("BookService=");
        Book book = bookDao.selectBookById(bookId);
        return book;
    }
}
