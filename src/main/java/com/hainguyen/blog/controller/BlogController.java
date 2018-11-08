package com.hainguyen.blog.controller;

import com.hainguyen.blog.model.BlogPersonal;
import com.hainguyen.blog.model.Category;
import com.hainguyen.blog.service.BlogService;
import com.hainguyen.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping(value = {"/", "/blog"})
    public ModelAndView listBlog(){
        Iterable<BlogPersonal> blogPersonals = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("posts/list");
        modelAndView.addObject("blogPersonals", blogPersonals);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView createFormBlog(){
        ModelAndView modelAndView = new ModelAndView("posts/create");
        modelAndView.addObject("blogPersonal", new BlogPersonal());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blogPersonal") BlogPersonal blogPersonal){
        blogService.save(blogPersonal);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        modelAndView.addObject("message", "Create blog successful");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView updateFormBlog(@PathVariable("id") int id){
        ModelAndView modelAndView;
        if(blogService.findById(id) != null) {
            BlogPersonal blogPersonal = blogService.findById(id);
            modelAndView = new ModelAndView("posts/edit");
            modelAndView.addObject("blogPersonal", blogPersonal);
        }else {
            modelAndView = new ModelAndView("error-404");
        }
        return modelAndView;
    }

    @PostMapping("/edit-blog")
    public ModelAndView saveBlogEdit(@ModelAttribute("blogPersonal") BlogPersonal blogPersonal){
        blogService.save(blogPersonal);
        ModelAndView modelAndView = new ModelAndView("posts/edit");
        modelAndView.addObject("message","Update blog successful");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView deleteBlog(@PathVariable("id") int id){
        ModelAndView modelAndView;
        if(blogService.findById(id) != null){
            blogService.remove(id);
            modelAndView = new ModelAndView("redirect:/");
            modelAndView.addObject("message", "Delete Blog successful");
        }else {
            modelAndView = new ModelAndView("error-404");
        }
        return modelAndView;
    }
}
