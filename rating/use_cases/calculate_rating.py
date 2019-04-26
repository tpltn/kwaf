from typing import List

from rating.entities.event import Event
from rating.entities.rating import Rating


class CalculateRatingUseCase:
    def call(self, events: List[Event]) -> Rating:
        # TODO: use regressor
        return Rating(len(events))
