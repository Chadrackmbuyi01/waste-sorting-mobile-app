package com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.repository;

import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
}
