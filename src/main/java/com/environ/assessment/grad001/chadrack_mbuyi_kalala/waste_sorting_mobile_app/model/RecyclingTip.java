package com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipId;
    @NotBlank(message = "Tip is mandatory")
    private String tip;

    public RecyclingTip(Builder builder) {
        this.tipId = builder.tipId;
        this.tip = builder.tip;
    }

    public RecyclingTip() {
    }
    public Long getTipId() {
        return tipId;
    }
    public String getTip() {
        return tip;
    }
    @Override
    public String toString() {
        return "RecyclingTip{" +
                "tipId=" + tipId +
                ", tip='" + tip + '\'' +
                '}';
    }

    public void setTipId(Long tipId) {

    }

    public static class Builder{
        private Long tipId;
        private String tip;

        public RecyclingTip.Builder setTip(String tip) {
            this.tip = tip;
            return this;
        }

        public Builder copy(RecyclingTip recyclingTip){
            this.tipId = recyclingTip.getTipId();
            this.tip = recyclingTip.getTip();
            return this;
        }

        public RecyclingTip build(){
            return new RecyclingTip(this);
        }
    }
}
