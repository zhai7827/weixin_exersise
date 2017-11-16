package com.zhai.mapping;


import com.zhai.entity.book.Book;

/**
 * Created by admin on 2017/10/31.
 */
public interface BookMapper {
    public Book selectBookById(Integer id);
}
