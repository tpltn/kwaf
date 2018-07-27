package org.kwaf.kwaf.entities

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "urls")
data class URL(@Id val id: UUID, val value: String)
