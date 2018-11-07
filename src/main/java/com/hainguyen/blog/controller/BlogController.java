package com.hainguyen.blog.controller;

import com.hainguyen.blog.model.BlogPersonal;
import com.hainguyen.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
        System.out.println("Thanh cong");
        blogService.save(blogPersonal);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        modelAndView.addObject("message", "Create blog successful");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView updateFormBlog(@PathVariable("id") int id){
        BlogPersonal blogPersonal = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blogPersonal", blogPersonal);
        return modelAndView;
    }

    @PostMapping("/edit-blog")
    public ModelAndView saveBlogEdit(@ModelAttribute("blogPersonal") BlogPersonal blogPersonal){
        blogService.save(blogPersonal);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("message","Update blog successful");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView deleteBlog(@PathVariable("id") int id){
        blogService.remove(id);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("message", "Delete Blog successful");
        return modelAndView;
    }
}
