package com.labdesoft.roteiro01.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.labdesoft.roteiro01.entity.Category;
import com.labdesoft.roteiro01.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    @Operation(summary = "Retorna todas as categorias existentes")
    public ResponseEntity<List<Category>> findAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/{name}")
    @Operation(summary = "Busca uma categoria específica")
    public ResponseEntity<Category> findCategoryByName(@PathVariable String name) {
        Category category = categoryService.getCategoryByName(name);
        if (category != null) {
            return ResponseEntity.ok().body(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    @Operation(summary = "Adiciona uma nova categoria")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category addedCategory = categoryService.addCategory(category);
        return ResponseEntity.ok().body(addedCategory);
    }

    @DeleteMapping("/delete/{name}")
    @Operation(summary = "Exclui uma categoria específica")
    public ResponseEntity<Void> deleteCategory(@PathVariable String name) {
        categoryService.deleteCategory(name);
        return ResponseEntity.noContent().build();
    }
}
