from functools import reduce

salaries = [30000, 45000, 35000, 50000, 38000]

revised = list(map(
    lambda s: s * 1.10 if s < 40000 else s,
    salaries
))
print("Revised Salaries:", revised)

eligible = list(filter(lambda s: s < 40000, salaries))
print("Eligible Salaries:", eligible)

total = reduce(lambda a, b: a + b, revised, 0)
print("Total Expenditure: Rs.", round(total, 2))