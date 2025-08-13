package com.chat_app_backend.service;

import com.chat_app_backend.dto.AuthRequest;
import com.chat_app_backend.dto.AuthResponse;

public interface AuthService {
    AuthResponse register(AuthRequest request);
    AuthResponse login(AuthRequest request);
}
