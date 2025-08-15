package org.springframeworkcore.mvc.javaannotationbased.dto.request.student;

import jakarta.annotation.Nonnull;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

public record StudentCreateRequestDTO(

        @NotBlank(message = "Username is required")
        String username,

        @NotBlank(message = "Password is required")
        String password
) {}
