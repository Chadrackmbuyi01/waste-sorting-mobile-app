package com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.model;

import lombok.Getter;

public class WasteCategory {

    private Long wasteId;
    private String name;
    private String description;

    public Long getWasteId() {
        return wasteId;
    }

    public void setWasteId(Long wasteId) {
        this.wasteId = wasteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
