package com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long disposalId;
    @NotBlank(message = "Category is mandatory")
    private String category;
    @NotBlank(message = "Guideline is mandatory")
    private String guidelineName;

    public DisposalGuideline(Builder builder) {
        this.category = builder.category;
        this.guidelineName = builder.guidelineName;
    }

    public DisposalGuideline() {

    }

    public Long getDisposalId() {
        return disposalId;
    }

    public void setDisposalId(Long disposalId) {
        this.disposalId = disposalId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGuidelineName() {
        return guidelineName;
    }

    public void setGuidelineName(String guidelineName) {
        this.guidelineName = guidelineName;
    }

    @Override
    public String toString() {
        return "DisposalGuideline{" +
                "disposalId=" + disposalId +
                ", category='" + category + '\'' +
                ", guidelineName='" + guidelineName + '\'' +
                '}';
    }

    public static class Builder{
        private Long disposalId;
        private String category;
        private String guidelineName;
        public Builder setDisposalId(Long disposalId) {
            this.disposalId = disposalId;
            return this;
        }
        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }
        public Builder setGuidelineName(String guidelineName) {
            this.guidelineName = guidelineName;
            return this;
        }
        public Builder copy(DisposalGuideline disposalGuideline){
            this.category = disposalGuideline.getCategory();
            this.guidelineName = disposalGuideline.getGuidelineName();

            return this;
        }
        public DisposalGuideline build(){
            return new DisposalGuideline(this);
        }
    }
}
