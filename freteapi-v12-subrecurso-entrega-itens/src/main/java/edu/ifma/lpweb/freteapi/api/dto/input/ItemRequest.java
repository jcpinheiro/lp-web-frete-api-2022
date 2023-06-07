package edu.ifma.lpweb.freteapi.api.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class ItemRequest {

    @NotBlank
    private String descricao;
}
