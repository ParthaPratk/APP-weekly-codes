parking_slots = [
    {"slot": "S1", "type": "Car",  "available": True},
    {"slot": "S2", "type": "Bike", "available": False},
    {"slot": "S3", "type": "Car",  "available": True},
    {"slot": "S4", "type": "Bike", "available": True},
    {"slot": "S5", "type": "Car",  "available": False}
]

def is_available(slot, vehicle_type):
    return (
        slot["type"].lower() == vehicle_type.lower()
        and slot["available"]
    )

print("Available Car Parking Slots:")

for slot in parking_slots:
    if is_available(slot, "Car"):
        print(slot["slot"])