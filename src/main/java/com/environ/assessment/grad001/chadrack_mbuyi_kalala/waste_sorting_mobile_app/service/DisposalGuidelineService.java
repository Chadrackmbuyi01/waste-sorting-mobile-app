package com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.service;

import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.model.DisposalGuideline;
import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.repository.IDisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineService {

    @Autowired
    private IDisposalGuidelineRepository disposalGuidelineRepository;

    public List<DisposalGuideline> getDisposalGuidelineList(){
        return disposalGuidelineRepository.findAll();
    }

    public DisposalGuideline getDisposalGuidelineById(Long disposalId){
        return disposalGuidelineRepository.findById(disposalId).orElse(null);
    }

    public DisposalGuideline saveDisposalGuideline(DisposalGuideline disposalGuideline){
        return disposalGuidelineRepository.save(disposalGuideline);
    }

    public void deleteDisposalGuideline(Long disposalId){
        disposalGuidelineRepository.deleteById(disposalId);
    }
}
