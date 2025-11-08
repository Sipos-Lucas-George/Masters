import sys
from random import shuffle

try:
    with open(sys.argv[1]) as file:
        lines = file.readlines()
except FileNotFoundError:
    print("File not found")

try:
    if int(sys.argv[2]) > len(lines):
        print(f"Sample greater than file lines! {sys.argv[2]} > {len(lines)}")
        exit(1)
    shuffle(lines)
    for i in range(int(sys.argv[2])):
        print(lines[i].strip())
except Exception:
    print(f"Invalid line: {sys.exc_info()[1]}")