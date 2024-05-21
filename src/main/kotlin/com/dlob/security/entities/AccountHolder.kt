package com.dlob.security.entities

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class AccountHolder(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val nationalId: String,
    val firstName: String,
    val surName: String,
    val cellphone: String,
    @OneToMany(mappedBy = "holder", cascade = [CascadeType.ALL], orphanRemoval = true)
    val accounts: List<Account>
    )