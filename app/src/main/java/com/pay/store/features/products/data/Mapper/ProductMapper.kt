import com.pay.productsapp.features.products.data.models.ProductDto
import com.pay.store.features.products.data.data_source.local.entities.ProductEntity
import com.pay.store.features.products.domain.models.Product

fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        title = title,
        description = description,
        image = image,
        category = category,
        price = price
    )
}

fun ProductDto.toEntity(): ProductEntity {
    return ProductEntity(
        id = id,
        title = title,
        description = description,
        image = image,
        category = category,
        price = price
    )
}

fun ProductEntity.toDomain(): Product {
    return Product(
        id = id,
        title = title,
        description = description,
        image = image,
        category = category,
        price = price
    )
}