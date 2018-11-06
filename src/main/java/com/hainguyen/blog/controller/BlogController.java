package com.hainguyen.blog.controller;

import com.hainguyen.blog.model.BlogPersonal;
import com.hainguyen.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public ModelAndView listBlog(){
        Iterable<BlogPersonal> blogPersonals = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogPersonals", blogPersonals);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView createFormBlog(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blogPersonal", new BlogPersonal());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blogPersonal") BlogPersonal blogPersonal){
        blogService.save(blogPersonal);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("message", "Create blog successful");
        return modelAndView;
    }
}
