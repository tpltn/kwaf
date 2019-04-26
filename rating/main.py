import json
from http.server import *

from rating.entities.event import Event
from rating.use_cases.calculate_rating import CalculateRatingUseCase


class HTTPHandler(BaseHTTPRequestHandler):
    def do_POST(self):
        self.send_response(200)
        self.send_header('Content-Type', 'application/json;charset=UTF-8')
        self.end_headers()

        content_len = int(self.headers.get('Content-Length'))
        body = self.rfile.read(content_len).decode("utf-8")

        objects = json.loads(body)
        events = list(map(lambda o: Event.build(o), objects))

        rating = CalculateRatingUseCase().call(events)
        self.wfile.write(rating.toJSON())


server = HTTPServer(("0.0.0.0", 8081), HTTPHandler)
server.serve_forever()
