package com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.service;

import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.model.WasteCategory;
import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.repository.IWasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {

    @Autowired
    private IWasteCategoryRepository wasteCategoryRepository;

    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    public WasteCategory getWasteCategoryById(Long wasteId) {
        return wasteCategoryRepository.findById(wasteId).orElse(null);
    }

    public WasteCategory saveWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    public void deleteWasteCategoryById(Long wasteId) {
        wasteCategoryRepository.deleteById(wasteId);
    }

}
