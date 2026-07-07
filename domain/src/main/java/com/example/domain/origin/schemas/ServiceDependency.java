package com.example.domain.origin.schemas;

import com.example.domain.origin.interfaces.INTERFACE_UsecaseAuthorizationService;

/**
 * Container for service dependencies.
 * Encapsulates all common dependencies required by services.
 *
 * @param authorizationService The service used for user authorization
 */
public record ServiceDependency(
        INTERFACE_UsecaseAuthorizationService authorizationService) {
}
