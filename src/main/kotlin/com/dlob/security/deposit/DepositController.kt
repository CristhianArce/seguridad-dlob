package com.dlob.security.deposit

import com.dlob.security.models.DepositRequest
import com.dlob.security.models.TransactionData
import com.google.gson.Gson
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DepositController(private val depositService: DepositService) {

   @PostMapping(path = ["/deposit"])
   fun deposit(@RequestBody depositRequest: DepositRequest) {
       val transactionData = depositService.deposit(depositRequest)
   }
}
