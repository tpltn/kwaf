package org.kwaf.kwaf.entities

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Event(@Id val id: String,
                 val userId: String,
                 val userAgent: UserAgent,
                 val url: URL,
                 val method: String,
                 val httpStatus: Int,
                 val committedAt: Date)

// FUTURE: params/body
