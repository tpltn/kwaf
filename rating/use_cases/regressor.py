from typing import List

from sklearn import tree


class Regressor:
    def call(self, x: List[List[float]], y: List[float], x_to_test: List[float]) -> float:
        regressor = tree.DecisionTreeRegressor(max_depth=3)
        regressor.fit(x, y)

        return regressor.predict(x_to_test)[0]
