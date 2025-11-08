import sys

if len(sys.argv) != 3:
    print("Run the program with 2 parameters")
    exit(1)

with open(sys.argv[1], "r") as file:
    first_file_numbers = set(file.readlines())

with open(sys.argv[2], "r") as file:
    second_file_numbers = set(file.readlines())

print("Overlap values:")
print(*sorted(list(first_file_numbers.intersection(second_file_numbers)), key=lambda x: int(x)))
