package com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.controller;

import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.model.RecyclingTip;
import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.service.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tips")
@Validated
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService recyclingTipService;

    @GetMapping
    public List<RecyclingTip> getAllRecyclingTips(){
        return recyclingTipService.getAllRecyclingTips();
    }

    @GetMapping("/{tipId}")
    public ResponseEntity<RecyclingTip> getTipById(@PathVariable Long tipId){
        RecyclingTip tip = recyclingTipService.getRecyclingTipById(tipId);
        return tip != null ? ResponseEntity.ok(tip) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RecyclingTip> createTip(@Valid @RequestBody RecyclingTip tip){
        return new ResponseEntity<>(recyclingTipService.saveRecyclingTip(tip), HttpStatus.CREATED);
    }

    @PutMapping("/{tipId}")
    public ResponseEntity<RecyclingTip> updateTip(@PathVariable Long tipId, @Valid @RequestBody RecyclingTip tip){
        RecyclingTip existingTip = recyclingTipService.getRecyclingTipById(tipId);
        if (existingTip != null) {
            return ResponseEntity.notFound().build();
        }
        tip.setTipId(tipId);
        return ResponseEntity.ok(recyclingTipService.saveRecyclingTip(tip));
    }

    @DeleteMapping("/{tipId}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long tipId){
        recyclingTipService.deleteRecyclingTipById(tipId);
        return ResponseEntity.noContent().build();
    }

}
