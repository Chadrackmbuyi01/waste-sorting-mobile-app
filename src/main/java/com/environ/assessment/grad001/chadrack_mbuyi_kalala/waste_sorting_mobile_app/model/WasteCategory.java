package com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wasteId;
    @NotBlank(message = "Name is mandatory")
    private String name;
    private String description;

    public WasteCategory (Builder builder){
        this.wasteId = builder.wasteId;
        this.name = builder.name;
        this.description = builder.description;
    }

    public WasteCategory(){

    }

    public Long getWasteId() {
        return wasteId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "WasteCategory{" +
                "wasteId=" + wasteId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void setWasteId(Long wasteId) {
    }

    public static class Builder{

        private Long wasteId;
        private String name;
        private String description;

        public WasteCategory.Builder setName(String name){
            this.name = name;
            return this;
        }

        public WasteCategory.Builder setDescription(String description){
            this.description = description;
            return this;
        }

        public WasteCategory.Builder copy(WasteCategory wasteCategory){
            this.wasteId = wasteCategory.getWasteId();
            this.name = wasteCategory.getName();
            this.description = wasteCategory.getDescription();
            return this;
        }

        public WasteCategory build(){
            return new WasteCategory(this);
        }
    }
}
