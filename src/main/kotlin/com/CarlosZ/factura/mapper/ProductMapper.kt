package com.CarlosZ.factura.mapper

import com.CarlosZ.factura.dto.ProductDto
import com.CarlosZ.factura.model.Product

object ProductMapper {

    fun mapToDto(product: Product): ProductDto {
        return ProductDto(
            product.id,
            "${product.description} ${product.brand}"
        )
    }
}