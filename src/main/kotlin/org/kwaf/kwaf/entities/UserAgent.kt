package org.kwaf.kwaf.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "useragents")
data class UserAgent(@Id val id: String, val name: String)
