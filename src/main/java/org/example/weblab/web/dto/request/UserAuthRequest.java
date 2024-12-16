package org.example.weblab.web.dto.request;

public record UserAuthRequest (
   String phone,
   String password
) {
}
