package com.example.apinotas.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class RequestCreacionNotaDTO {
    @NotNull
    @NotBlank
    @Min(10)
    private String title;

    @NotNull
    @NotBlank
    @Max(50)
    private String contente;

}
