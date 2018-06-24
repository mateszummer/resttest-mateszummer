package com.codecool.language.mateszummer.RestApi;


import com.codecool.language.mateszummer.Service.CategoryService;
import com.codecool.language.mateszummer.Service.ItemService;
import com.codecool.language.mateszummer.model.Category;
import com.codecool.language.mateszummer.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class WebRest {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ItemService itemService;

    @GetMapping(value = "/items")
    public String getItemPage(Model model){
        List<Category> categories = categoryService.getAll();
        List<Item> items = itemService.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("items",items);
        return "items";
    }
}
