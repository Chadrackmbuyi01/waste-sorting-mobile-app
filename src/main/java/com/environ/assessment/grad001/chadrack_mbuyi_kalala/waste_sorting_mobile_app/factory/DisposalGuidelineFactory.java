package com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.factory;

import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.helper.Helper;
import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.model.DisposalGuideline;

public class DisposalGuidelineFactory {

    public static DisposalGuideline build (String category, String guidelineName) {
        Helper.checkStringParameter("category", category);
        Helper.checkStringParameter("guidelineName", guidelineName);
        if (Helper.isEmptyOrNull(category) || Helper.isEmptyOrNull(guidelineName))
            throw new IllegalArgumentException("Category and guideline name can't be empty");
        return new DisposalGuideline.Builder().setCategory(category).setGuidelineName(guidelineName).build();


    }
}
