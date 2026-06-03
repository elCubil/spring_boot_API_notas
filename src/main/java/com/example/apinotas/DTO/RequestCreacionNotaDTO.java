package com.example.apinotas.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class RequestCreacionNotaDTO {
    @NotNull
    @NotBlank
    @Size(min=5)
    private String title;

    @NotNull
    @NotBlank
    @Size(max=50,min=10)
    private String content;

}
