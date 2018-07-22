package org.kwaf.kwaf.entities

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class UserAgent(@Id val id: String, val value: String)
