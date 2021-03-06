package org.togglz.cdi.test;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.context.FeatureContext;

public enum BasicFeatures implements Feature {

    FEATURE1,
    
    @EnabledByDefault
    FEATURE2;

    @Override
    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }

}
