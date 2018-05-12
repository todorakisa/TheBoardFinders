package com.example.app.Service;

import com.example.app.model.RegistrationModel;
import org.springframework.stereotype.Service;

public interface UserService{
    void register(RegistrationModel registrationModel);
}
