package com.dlob.security.repository

import com.dlob.security.entities.EventLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EventLogRepo: JpaRepository<EventLog, Long>