from functools import reduce

consumption = [8, 12, 15, 6, 20, 9]

high = list(filter(lambda u: u > 10, consumption))
print("Consumption > 10 units:", high)

costs = list(map(lambda u: u * 6, consumption))
print("Daily Costs:", costs)

total_units = reduce(lambda a, b: a + b, consumption, 0)
print("Total Consumption:", total_units, "units")

def calculate_bill(units):
    return units * 6

total_bill = calculate_bill(total_units)
print("Total Bill: Rs.", total_bill)

print("Original Data:", consumption)