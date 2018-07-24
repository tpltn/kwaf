package org.kwaf.kwaf.entities

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class Event(@Id val id: String,
                 val userId: String,
                 @ManyToOne @JoinColumn(name = "userAgent") val userAgent: UserAgent,
                 @ManyToOne @JoinColumn(name = "url") val url: URL,
                 val method: String,
                 val httpStatus: Int,
                 val committedAt: Date)

// FUTURE: params/body
