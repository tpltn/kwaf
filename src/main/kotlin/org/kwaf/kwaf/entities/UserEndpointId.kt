package org.kwaf.kwaf.entities

import java.io.Serializable
import java.util.*

data class UserEndpointId(
        val userId: UUID? = null,
        val endpointId: UUID? = null
) : Serializable
