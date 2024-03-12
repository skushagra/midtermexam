package com.midtermexam.midtermexam.dto;

import com.midtermexam.midtermexam.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateCartDTO {

    private Long userId;
    private String date;
    private List<Product> products;

}
