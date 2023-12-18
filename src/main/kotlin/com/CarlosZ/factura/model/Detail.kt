package com.CarlosZ.factura.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.text.DecimalFormat

@Entity
@Table(name= "detail")
class Detail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var quantity: Int? = null
    var price: Int?= null
    @Column(name= "invoice_id")
    var invoiceId: Long?= null
    @Column(name= "product_id")
    var productId: Long?= null
}