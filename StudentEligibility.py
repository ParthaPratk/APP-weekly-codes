students = {
    "Arun":   {"Python": "Pass", "DataStructures": "Pass"},
    "Bala":   {"Python": "Pass", "DataStructures": "Fail"},
    "Charan": {"Python": "Pass", "DataStructures": "Pass"},
    "Divya":  {"Python": "Fail", "DataStructures": "Pass"}
}

def eligible(student):
    return (
        student["Python"] == "Pass"
        and student["DataStructures"] == "Pass"
    )

print("Eligible Students:")
for name, results in students.items():
    if eligible(results):
        print(name)