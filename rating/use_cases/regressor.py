from sklearn import tree

X = [
    [50], [40], [10]

]

y = [
    1, 1, 0
]

regressor = tree.DecisionTreeRegressor(max_depth=3)
regressor.fit(X, y)

X_test = [[50]]
y_predicted = regressor.predict(X_test)

print(y_predicted)
