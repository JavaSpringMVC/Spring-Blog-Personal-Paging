package com.hainguyen.blog.controller;

import com.hainguyen.blog.model.Category;
import com.hainguyen.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/list-category")
    public ModelAndView listCategory() {
        Iterable<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/create-category")
    public ModelAndView createCategoryForm() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create-category")
    public String saveCreateCategory(@ModelAttribute("category") Category category, Model model) {
        categoryService.save(category);
        model.addAttribute("message", "Create Category Successful");
        return "redirect:/list-category";
    }

    @GetMapping("/delete-category/{id}")
    public String deleteCategory(@PathVariable("id") int id, Model model) {
        if (categoryService.findById(id) != null) {
            categoryService.remove(id);
            model.addAttribute("message", "Delete Category Successful");
            return "redirect:/list-category";
        }else {
            return "error-404";
        }
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView editCategoryForm(@PathVariable("id") int id) {
        Category category = categoryService.findById(id);
        ModelAndView modelAndView;
        if (categoryService.findById(id) != null) {
            modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category", category);
        }else {
            modelAndView = new ModelAndView("/error-404");
        }
        return modelAndView;
    }

    @PostMapping("/edit-category")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("message", "Edit category successful");
        return modelAndView;
    }
}
