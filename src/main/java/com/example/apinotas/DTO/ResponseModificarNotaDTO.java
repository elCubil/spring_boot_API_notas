package com.example.apinotas.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResponseModificarNotaDTO {

    private Long id;

    private String title;

    private String content;
}
