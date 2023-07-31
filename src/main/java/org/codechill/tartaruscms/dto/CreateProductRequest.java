package org.codechill.tartaruscms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateProductRequest {

    private String name;

    private float price;

    private String image;

    private Long storeId;
}
