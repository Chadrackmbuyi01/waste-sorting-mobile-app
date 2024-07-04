package com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.controller;

import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.model.DisposalGuideline;
import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.service.DisposalGuidelineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guideluine")
@Validated
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService disposalGuidelineService;

    @GetMapping
    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return disposalGuidelineService.getAllDisposalGuidelines();
    }

    @GetMapping("/{disposalId}")
    public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable Long disposalId) {
        DisposalGuideline guideline = disposalGuidelineService.getDisposalGuidelineById(disposalId);
        return guideline == null ? ResponseEntity.ok(guideline) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DisposalGuideline> createDisposalGuideline(@Valid @RequestBody DisposalGuideline disposalGuideline) {
        return new ResponseEntity<>(disposalGuidelineService.saveDisposalGuideline(disposalGuideline), HttpStatus.CREATED);
    }

    @PutMapping("/{disposalId}")
    public ResponseEntity<DisposalGuideline> updateGuideline(@PathVariable Long disposalId, @Valid @RequestBody DisposalGuideline disposalGuideline) {
        DisposalGuideline existingDisposalGuideline = disposalGuidelineService.getDisposalGuidelineById(disposalId);
        if(existingDisposalGuideline == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        disposalGuideline.setDisposalId(disposalId);
        return ResponseEntity.ok(disposalGuidelineService.saveDisposalGuideline(disposalGuideline));
    }

    @DeleteMapping("/{disposalId}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long disposalId) {
        disposalGuidelineService.deleteDisposalGuidelineById(disposalId);
        return ResponseEntity.noContent().build();
    }
}
