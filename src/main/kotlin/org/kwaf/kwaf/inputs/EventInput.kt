package org.kwaf.kwaf.inputs

import java.util.*

data class EventInput(
        val userId: UUID,
        val host: String,
        val userAgent: String
)
