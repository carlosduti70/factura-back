package com.CarlosZ.factura.service

import com.CarlosZ.factura.model.Detail
import com.CarlosZ.factura.repository.ClientRepository
import com.CarlosZ.factura.repository.DetailRepository
import com.CarlosZ.factura.repository.InvoiceRepository
import com.CarlosZ.factura.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class detailService {
    @Autowired
    lateinit var invoiceRepository: InvoiceRepository
    @Autowired
    lateinit var productRepository: ProductRepository
    @Autowired
    lateinit var detailRepository: DetailRepository

    fun list ():List<Detail>{
        return detailRepository.findAll()
    }

    fun save(detail: Detail):Detail{
        try {
            invoiceRepository.findById(detail.invoiceId)
                ?: throw Exception("Id de factura no encontrado")
            productRepository.findById(detail.productId)
                ?: throw Exception("Id de producto no encontrado")
            return detailRepository.save(detail)
        }catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(detail: Detail): Detail{
        try {
            detailRepository.findById(detail.id)
                ?: throw Exception("ID no existe")

            return detailRepository.save(detail)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(detail:Detail): Detail{
        try{
            val response = detailRepository.findById(detail.id)
                ?: throw Exception("ID no existe")
            response.apply {
                quantity=detail.quantity
            }
            return detailRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?):Detail?{
        return detailRepository.findById(id)
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = detailRepository.findById(id)
                ?: throw Exception("ID no existe")
            detailRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}