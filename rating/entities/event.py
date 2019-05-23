from typing import Dict


class Event:
    def __init__(self, user_agent: str, host: str, rating: float):
        self.user_agent = user_agent
        self.host = host
        self.rating = rating

    @classmethod
    def build(cls, d: Dict[str, str]) -> 'Event':
        return cls(d['userAgent'], d['host'], float(d['rating']))
