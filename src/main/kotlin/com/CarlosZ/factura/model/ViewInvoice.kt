package com.CarlosZ.factura.model

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

class ViewInvoice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nui: String? = null
    var fullname: String?= null
    var address: String?= null
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var code: String? = null
    @Column(name="create_at")
    var createAt: String? = null
    var total: String?= null
    @Column(name="client_id")
    var clientId: Long? = null
}