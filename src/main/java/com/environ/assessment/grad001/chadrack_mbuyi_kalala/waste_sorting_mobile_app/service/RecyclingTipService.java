package com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.service;

import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.model.RecyclingTip;
import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.repository.IRecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {

    @Autowired
    private IRecyclingTipRepository recyclingTipRepository;

    public List<RecyclingTip> getAllRecyclingTips() {
        return recyclingTipRepository.findAll();
    }

    public RecyclingTip getRecyclingTipById(Long tipId) {
        return recyclingTipRepository.findById(tipId).orElse(null);
    }

    public RecyclingTip saveRecyclingTip(RecyclingTip recyclingTip) {
        return recyclingTipRepository.save(recyclingTip);
    }

    public void deleteRecyclingTipById(Long tipId) {
        recyclingTipRepository.deleteById(tipId);
    }
}
