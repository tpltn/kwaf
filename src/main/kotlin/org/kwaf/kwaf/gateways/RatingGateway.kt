package org.kwaf.kwaf.gateways

import org.kwaf.kwaf.entities.Rating
import org.kwaf.kwaf.entities.UserEndpointId
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.Repository
import org.springframework.data.repository.query.Param
import java.util.*

interface RatingGateway : Repository<Rating, UserEndpointId> {
    @Query(
            value = """
                WITH total_counters AS
                (
                  SELECT
                    user_id,
                    count(*) AS total_events
                  FROM events
                  GROUP BY user_id
                )
                SELECT
                  c.user_id,
                  c.endpoint_id,
                  tc.total_events,
                  c.total_events AS events_per_endpoint,
                  (c.total_events / tc.total_events\:\:DOUBLE PRECISION) AS average_rate
                FROM
                  counters c JOIN total_counters tc on c.user_id = tc.user_id
                ORDER BY user_id, endpoint_id
            """,
            nativeQuery = true
    )
    fun findAll(): Iterable<Rating>

    @Query(
            value = """
                WITH total_counters AS
                (
                  SELECT
                    user_id,
                    count(*) AS total_events
                  FROM events
                  WHERE user_id = :user_id
                  GROUP BY user_id
                )
                SELECT
                  c.user_id,
                  c.endpoint_id,
                  tc.total_events,
                  c.total_events AS events_per_endpoint,
                  (c.total_events / tc.total_events\:\:DOUBLE PRECISION) AS average_rate
                FROM
                  counters c JOIN total_counters tc on c.user_id = tc.user_id
                WHERE c.user_id = :user_id
                ORDER BY user_id, endpoint_id
            """,
            nativeQuery = true
    )
    fun findByUserId(@Param("user_id") userId: UUID): Iterable<Rating>
}
