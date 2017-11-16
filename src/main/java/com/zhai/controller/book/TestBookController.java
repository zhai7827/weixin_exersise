package com.zhai.controller.book;

import com.zhai.entity.book.Book;
import com.zhai.service.IBookService;
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
    @Resource
    private IBookService bookService;
    @RequestMapping(value="/test")
    public  @ResponseBody Object testBook(){
        Book book  = bookService.selectBook(2);
        return book;
    }
}
