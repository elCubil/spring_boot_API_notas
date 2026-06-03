package com.example.apinotas.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ResponseListarNotasDTO {


    private Long id;

    private String title;

    private String content;

}
