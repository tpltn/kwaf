package org.kwaf.kwaf.entities

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "endpoints")
data class Endpoint(
        @Id
        val id: UUID,
        val method: String,
        val url: String
)
