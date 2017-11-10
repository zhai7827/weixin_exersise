package com.zhai.book.web;

import com.zhai.book.domin.Book;
import com.zhai.book.service.impl.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by admin on 2017/11/9.
 */
@Controller
@RequestMapping(value="/book")
public class TestBookController {
    @Resource BookService bookService;
    @RequestMapping(value="/test")
    public  @ResponseBody Object testBook(){
        Book book  = bookService.selectBookById(2);
        return book;
    }
}
