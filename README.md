# kwaf
Web application firewall as a service

## Architecture

```ditaa
+---------------------------------------------------------------------------------+
|                                                   Web Application Firewall (WAF)|
|   +    +    +                                                                   |
|   |    |    |                                                                   |
|   v    v    v                                                                   |
| +-------------+                              proxied http call                  |
| | +---------+ |                                      +                          |
| | | nginx   | |<-----------------------------------+ |                          |
| | | HAProxy | |        read logs                   | |                          |
| | +---------+ |                                    | |                          |
| +---+----+----+                                    | |                          |
|     |    |                                         | |                          |
|     v    v                                         | |                          |
| +------------+                                     | |                          |
| |    API     |                                     | |                          |
| +------------+                                     | v                          |
|                                              +------------+                     |
|                                              |kwaf-ingress|                     |
|                                              +-----+------+                     |
|                                                    |                            |
|                                                    |                            |
|                                                    |                            |
|                                                    | push event                 |
|                                                    |                            |
|                                                    |                            |
|                                                    v                            |
|              +--------------+                  +-----------------------------+  |
|    counters  | redis        |                  |      kwaf                   |  |
|              | hazelcast    |                  | POST /events                |  |
|              | apache ignite|     persist      | GET /ratings                |  |
|              |              |<-----------------+ GET /ratings?user_id=userID |  |
|    logs      | PostgreSQL   |                  |                             |  |
|              +--------------+                  +-----------------------------+  |
|                                                                                 |
+---------------------------------------------------------------------------------+
``` 

### GET /ratings example
```json
[
    {
        "userId": "11111111-949b-40fb-8172-6e55b36cf53f",
        "endpointId": "0c188425-195b-4e68-87fb-db1119a21793",
        "totalEvents": 25,
        "eventsPerEndpoint": 8,
        "averageRate": 0.32
    },
    {
        "userId": "11111111-949b-40fb-8172-6e55b36cf53f",
        "endpointId": "50293986-cacb-479d-beba-f1238ed64584",
        "totalEvents": 25,
        "eventsPerEndpoint": 1,
        "averageRate": 0.04
    },
    {
        "userId": "11111111-949b-40fb-8172-6e55b36cf53f",
        "endpointId": "7054fe54-482f-44be-823b-4e63c6464e28",
        "totalEvents": 25,
        "eventsPerEndpoint": 4,
        "averageRate": 0.16
    },
    {
        "userId": "11111111-949b-40fb-8172-6e55b36cf53f",
        "endpointId": "cbbf408e-c76c-402c-bd23-e65ed9224aeb",
        "totalEvents": 25,
        "eventsPerEndpoint": 12,
        "averageRate": 0.48
    }
]
```
