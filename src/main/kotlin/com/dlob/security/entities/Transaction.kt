package com.dlob.security.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.util.UUID

@Entity
data class Transaction(
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val reference: UUID,
    val type: String,
    val amount: BigDecimal,
    val currency: String,
    val description: String,
    val account: String)