package com.example.domain.origin.spring;

import com.example.domain.origin.entities.SERVICE_Abstract;
import com.example.domain.origin.interfaces.INTERFACE_UsecaseAuthorizationService;
import com.example.domain.origin.schemas.ServiceDependency;

/**
 * Abstract base class for Spring beans that wrap services.
 * Provides common functionality for creating service dependencies
 * and exposing the service instance.
 *
 * @param <I> The service input type
 * @param <O> The service output type
 * @param <S> The concrete service type extending SERVICE_Abstract
 */
public abstract class BEAN_Abstract<I, O, S extends SERVICE_Abstract<I, O>> {

    protected final INTERFACE_UsecaseAuthorizationService authorizationService;
    protected final ServiceDependency dependencies;
    protected S service;

    /**
     * Constructor that sets up common dependencies.
     * Subclasses should call this and then create their specific service.
     *
     * @param authorizationService the authorization service injected by Spring
     */
    protected BEAN_Abstract(INTERFACE_UsecaseAuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
        this.dependencies = new ServiceDependency(authorizationService);
    }

    /**
     * Factory method for subclasses to create their specific service instance.
     * Called during construction after dependencies are set up.
     *
     * @return the concrete service instance
     */
    protected abstract S createService();

    public S getService() {
        if (this.service == null) {
            this.service = createService();
        }
        return service;
    }
}
