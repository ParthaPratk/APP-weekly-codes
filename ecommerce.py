def discounted_price(price):
    if price > 1000:
        return price * 0.80
    return price


prices = [500, 1200, 2000, 800, 1500]

discounted = list(map(discounted_price, prices))
print("Discounted Prices:", discounted)

eligible = list(filter(lambda p: p > 1000, prices))
print("Eligible Products:", eligible)

print("Original Prices:", prices)