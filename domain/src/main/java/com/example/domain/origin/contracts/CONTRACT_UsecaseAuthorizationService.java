package com.example.domain.origin.contracts;

import org.springframework.stereotype.Service;

import com.example.domain.origin.interfaces.INTERFACE_UsecaseAuthorizationService;
import com.example.domain.origin.schemas.User;

@Service
public class CONTRACT_UsecaseAuthorizationService implements INTERFACE_UsecaseAuthorizationService {

    @Override
    public boolean isAuthorized(User user, String usecaseName) {
        // Custom authorization: allow all authenticated users
        // Or implement role-based check: return "ADMIN".equals(user.role());
        System.out.println("Inside CONTRACT_UsecaseAuthorizationService");
        System.out.println("Authorizing user " + user.email() + " for usecase " + usecaseName);
        return user != null && user.id() != null;
    }

}
