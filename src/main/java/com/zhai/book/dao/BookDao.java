package com.zhai.book.dao;

import com.zhai.book.domin.Book;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/10/31.
 */
@Repository
public interface BookDao {
    public Book selectBookById(Integer bookId);
}
