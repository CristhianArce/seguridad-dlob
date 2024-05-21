package com.dlob.security.repository

import com.dlob.security.entities.Account
import com.dlob.security.entities.Param
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParamRepository: JpaRepository<Param, Long>