from functools import reduce

marks = [45, 60, 75, 90, 35]

passed = list(filter(lambda m: m >= 50, marks))
print("Marks >= 50:", passed)

revised = list(map(lambda m: min(m + 5, 100), marks))
print("Grace Marks:", revised)

total = reduce(lambda a, b: a + b, revised, 0)
print("Total Marks:", total)