package org.kwaf.kwaf.gateways

import org.kwaf.kwaf.entities.Endpoint
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import java.util.*

interface CounterGateway : PagingAndSortingRepository<Endpoint, UUID> {
    @Query(
            value = "INSERT INTO counters AS c (user_id, endpoint_id, total_events) VALUES (:user_id, :endpoint_id, 1) ON CONFLICT (user_id, endpoint_id) DO UPDATE SET total_events = c.total_events + 1 RETURNING total_events",
            nativeQuery = true
    )
    fun incrementTotalEvents(@Param("user_id") userId: UUID, @Param("endpoint_id") endpointId: UUID): Int
}
