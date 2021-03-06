package org.togglz.servlet.test.user.thread;

import java.util.Arrays;

import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.FeatureState;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.mem.InMemoryStateRepository;
import org.togglz.core.user.UserProvider;
import org.togglz.core.user.thread.ThreadLocalUserProvider;

public class CopyOfThreadBasedUsersConfiguration implements TogglzConfig {

    @Override
    public Class<? extends Feature> getFeatureClass() {
        return UserDependentFeature.class;
    }

    @Override
    public StateRepository getStateRepository() {
        InMemoryStateRepository repository = new InMemoryStateRepository();
        repository.setFeatureState(new FeatureState(UserDependentFeature.DISABLED, false));
        repository.setFeatureState(new FeatureState(UserDependentFeature.ENABLED_FOR_ALL, true));
        repository.setFeatureState(new FeatureState(UserDependentFeature.ENABLED_FOR_CK, true, Arrays.asList("ck")));
        return repository;
    }

    @Override
    public UserProvider getUserProvider() {
        return new ThreadLocalUserProvider();
    }

}
