package com.example.demo.controller;


import com.example.demo.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.demo.entity.books;
import com.example.demo.service.impl.BookServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookServicelmpl;
    @ResponseBody
    @RequestMapping("/loogin")
    public  List<books> main(){
        List<books> list= bookServicelmpl.selectList();

        return list;
    }

    //   根据id 删除书籍
    @ResponseBody
    @RequestMapping(value = "/del")
    public String deleteById(Integer id){ //PathVariable 表明它是前端传过来的一个参数
        bookServicelmpl.deleteById(id);
        return "login";
    }

    @RequestMapping("/add")
    public String add(String bookName,String author,String category,String press,Integer sum,Integer sumInw,String isbn,double price,String bookUrl){
        bookServicelmpl.insert(bookName,author,category,press,sum,sumInw,isbn,price,bookUrl);
        return "login";
    }

    @RequestMapping("selectbyisbn")
    public  List<books> selectbyisbn(String isbn){
        List<books> list=bookServicelmpl.selectbyisbn(isbn);

        return list;
    }

    @RequestMapping("/update")
    public String update(String bookId,String bookName,String author,String category,String press,Integer sum,Integer sumInw,String isbn,double price,String bookUrl){
        bookServicelmpl.update(bookId,bookName,author,category,press,sum,sumInw,isbn,price,bookUrl);
        return "login";
    }
}
