package com.CarlosZ.factura.controller

import com.CarlosZ.factura.model.Invoice
import com.CarlosZ.factura.service.InvoiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoice")
class InvoiceController {
    @Autowired
    lateinit var invoiceService: InvoiceService

    @GetMapping
    fun list ():List <Invoice>{
        return invoiceService.list()
    }

    @PostMapping
    fun save (@RequestBody invoice: Invoice):ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.save(invoice), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody invoice:Invoice):ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.update(invoice), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody invoice:Invoice):ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.updateName(invoice), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(invoiceService.listById (id), HttpStatus.OK)

    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return invoiceService.delete(id)
    }

//------------------------------------------------------------------------------
    @GetMapping("/filter-total/{value}")
    fun listTotals (@PathVariable("value") value: Double ):ResponseEntity<*>{
        return ResponseEntity(invoiceService.listByTotal(value), HttpStatus.OK)
    }

    @GetMapping("/filter-best/{value}")
    fun listBestSellers (@PathVariable("value") value: Double ):ResponseEntity<*>{
        return ResponseEntity(invoiceService.listBybestSellers(value), HttpStatus.OK)
    }

    @GetMapping("/filter-big/{value}")
    fun listBigInvoice (@PathVariable("value") value: Double ):ResponseEntity<*>{
        return ResponseEntity(invoiceService.listBybigInvoice(value), HttpStatus.OK)
    }
}