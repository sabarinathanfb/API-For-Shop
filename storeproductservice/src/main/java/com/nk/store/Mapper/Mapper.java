package com.nk.store.Mapper;

import com.nk.store.dtos.ResponseProductDto;
import com.nk.store.models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static ResponseProductDto toResponseProductDto(Product product){

        if (product == null) {
            return null;
        }
        ResponseProductDto responseProductDto = new ResponseProductDto();
        responseProductDto.setId(product.getId());
        responseProductDto.setName(product.getName());
        responseProductDto.setPrice(product.getPrice());
        responseProductDto.setImage(product.getImage());
        responseProductDto.setBrand(product.getBrand());
        responseProductDto.setQuantity(product.getQuantity());
        responseProductDto.setSku(product.getSku());
        return responseProductDto;

    }
    public static List<ResponseProductDto> toResponseProductgDtoList(List<Product> products){

        if (products == null){
            return null;
        }
        return products.stream()
                .map(Mapper::toResponseProductDto)
                .collect(Collectors.toList());
    }
}
