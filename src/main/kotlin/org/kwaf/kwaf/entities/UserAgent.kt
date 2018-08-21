package org.kwaf.kwaf.entities

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "useragents")
data class UserAgent(
        @Id
        val id: UUID,

        val name: String
)
