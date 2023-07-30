package org.codechill.tartaruscms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateProductRequest {
    private String name;

    private float price;

    private String image;
}
