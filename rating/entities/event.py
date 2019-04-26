from typing import Dict


class Event:
    def __init__(self, user_agent: str, host: str):
        self.user_agent = user_agent
        self.host = host

    @classmethod
    def build(cls, d: Dict[str, str]) -> 'Event':
        return cls(d['userAgent'], d['host'])
