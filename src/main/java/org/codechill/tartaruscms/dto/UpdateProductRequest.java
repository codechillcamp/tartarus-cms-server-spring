package org.codechill.tartaruscms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class UpdateProductRequest {

    private Long id;

    private String name;

    private float price;

    private String image;
}
