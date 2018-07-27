package org.kwaf.kwaf.web.inputs

import java.util.*

data class EventInput(val userId: String,
                      val userAgent: String,
                      val url: String,
                      val method: String,
                      val httpStatus: Int,
                      val committedAt: Date)
