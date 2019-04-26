import json


class Rating:
    def __init__(self, rating: float):
        self.rating = rating

    def toJSON(self) -> str:
        return json.dumps(self, default=lambda o: o.__dict__).encode(encoding='utf_8')
