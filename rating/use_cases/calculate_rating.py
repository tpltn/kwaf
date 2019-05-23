from typing import List

from rating.entities.event import Event
from rating.entities.rating import Rating
from rating.use_cases.regressor import Regressor


class CalculateRatingUseCase:
    def __init__(self, regressor: Regressor):
        self.regressor = regressor

    def call(self, events: List[Event]) -> Rating:
        fit_data = events[:-1]
        to_predict = events[-1]

        x = list(map(lambda e: [e.user_agent, e.host], fit_data))
        y = list(map(lambda e: e.rating / 100, fit_data))
        x_test = [to_predict.user_agent, to_predict.host]

        return Rating(self.regressor.call(x, y, x_test) * 100)
