package org.kwaf.kwaf.entities

import java.io.Serializable
import java.util.*

// TODO: why default ctors from jetbrains don't work?
data class CounterId(
        val userId: UUID? = null,
        val endpointId: UUID? = null
) : Serializable
