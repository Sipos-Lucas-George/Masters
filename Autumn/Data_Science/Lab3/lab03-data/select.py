import sys

try:
    with open(sys.argv[1]) as file:
        lines = file.readlines()
except FileNotFoundError:
    print("File not found")

try:
    for line_number in sorted(sys.argv[2:], key=lambda x: int(x)):
        for index, line in enumerate(lines, 1):
            if int(line_number) == index:
                print(line.strip())
except Exception:
    print(f"Invalid line: {sys.exc_info()[1]}")