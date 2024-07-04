package com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.controller;

import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.model.WasteCategory;
import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Validated
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService wasteCategoryService;

    @GetMapping("all")
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryService.getAllWasteCategories();
    }

    @GetMapping("read/{wasteId}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable Long wasteId) {
        WasteCategory wasteCategory = wasteCategoryService.getWasteCategoryById(wasteId);
        return wasteCategory == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(wasteCategory);
    }

    @PostMapping("save")
    public ResponseEntity<WasteCategory> createCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        return new ResponseEntity<>(wasteCategoryService.saveWasteCategory(wasteCategory), HttpStatus.CREATED);
    }

    @PutMapping("update/{wasteId}")
    public ResponseEntity<WasteCategory> updateCategory(@PathVariable Long wasteId, @Valid @RequestBody WasteCategory wasteCategory) {
        WasteCategory existingCategory = wasteCategoryService.getWasteCategoryById(wasteId);
        if (existingCategory == null) {
            return ResponseEntity.notFound().build();
        }
        wasteCategory.setWasteId(wasteId);
        return ResponseEntity.ok(wasteCategoryService.saveWasteCategory(wasteCategory));
    }

    @DeleteMapping("delete/{wasteId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long wasteId) {
        wasteCategoryService.deleteWasteCategoryById(wasteId);
        return ResponseEntity.noContent().build();
    }
}
