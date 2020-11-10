package com.example.demo.controller;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.NewsEntity;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.NewsRepository;
import jdk.internal.vm.annotation.Contended;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class AppController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    NewsRepository newsRepository;

    @GetMapping("")
    public String user(Model model) {
        return "redirect:/page1";
    }

    @GetMapping("/page{pageid}")
    public String getpage(@PathVariable("pageid") int pageid, Model model) {

        Page<NewsEntity> page = findByPage(pageid);
        List<NewsEntity> newsEntityList = page.getContent();
        model.addAttribute("currentPage", pageid);
        model.addAttribute("totalPage", page.getTotalPages());

        model.addAttribute("category", categoryRepository.findAll());
        model.addAttribute("news", newsEntityList);
        return "index";
    }

    private Page<NewsEntity> findByPage(int pageid) {
        Pageable pageable = PageRequest.of(pageid - 1,10);
        return newsRepository.findAll(pageable);
    }

    @GetMapping("/category{categoryid}")
    public String detailProduct(@PathVariable("categoryid") Long categoryId, Model model) {

        model.addAttribute("news", newsRepository.findByCategoryId(categoryId));

        model.addAttribute("category", categoryRepository.findAll());

        return "index";
    }

    @GetMapping("/category{categoryid}/{productid}")
    public String detailProduct(@PathVariable("categoryid") Long categoryId, @PathVariable("productid") Long productId, Model model) {
        model.addAttribute("category", categoryRepository.findAll());
        NewsEntity neww = newsRepository.findById(productId).get();
        model.addAttribute("neww", neww);
        return "newDetail";
    }
}
