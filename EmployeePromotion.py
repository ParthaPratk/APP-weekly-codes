employees = {
    "Ravi":  {"experience": 6, "training": True,  "rating": 5},
    "Priya": {"experience": 3, "training": True,  "rating": 4},
    "Kumar": {"experience": 8, "training": False, "rating": 5},
    "Meena": {"experience": 7, "training": True,  "rating": 4}
}

def promotion_eligible(employee):
    return (
        employee["experience"] >= 5
        and employee["training"]
        and employee["rating"] >= 4
    )

print("Employees Eligible for Promotion:")
for name, details in employees.items():
    if promotion_eligible(details):
        print(name)