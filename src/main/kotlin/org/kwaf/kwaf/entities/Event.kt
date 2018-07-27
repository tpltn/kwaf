package org.kwaf.kwaf.entities

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "events")
data class Event(@Id val id: String,
                 @Column(name = "userid") val userId: String,
                 @ManyToOne @JoinColumn(name = "useragent") val userAgent: UserAgent,
                 @ManyToOne @JoinColumn(name = "url") val url: URL,
                 val method: String,
                 @Column(name = "httpstatus") val httpStatus: Int,
                 @Column(name = "committedat") val committedAt: Date)
