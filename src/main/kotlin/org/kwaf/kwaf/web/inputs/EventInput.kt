package org.kwaf.kwaf.web.inputs

import java.util.*

data class EventInput(
        val userId: UUID,
        val host: String,
        val userAgent: String
)
