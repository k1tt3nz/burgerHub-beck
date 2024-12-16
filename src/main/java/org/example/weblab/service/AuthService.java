package org.example.weblab.service;

import org.example.weblab.entity.User;
import org.example.weblab.repository.UserRepository;
import org.example.weblab.web.dto.request.UserAuthRequest;
import org.example.weblab.web.dto.response.UserAuthResponse;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService {
/*
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final String JWT_SECRET = "secret-key";
    private final long JWT_EXPIRATION_TIME = 864_000_00;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserAuthResponse authenticateUser(UserAuthRequest userAuthRequest) {
        User user = userRepository.findByPhone(userAuthRequest.phone())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(userAuthRequest.password(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        String token = generateJwtToken(user);

        return new UserAuthResponse(token);
    }

    private String generateJwtToken(User user) {
        return Jwts.builder()
                .setSubject(user.getPhoneNumber())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_TIME))
                .claim("userId", user.getId().toString())
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

 */
}
