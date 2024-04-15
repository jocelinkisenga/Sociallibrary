package com.library.Sociallibrary.Dto;

import java.io.Serializable;

/**
 * DTO for {@link com.library.Sociallibrary.Entities.User}
 */
public record UserDto(String password) implements Serializable {
}