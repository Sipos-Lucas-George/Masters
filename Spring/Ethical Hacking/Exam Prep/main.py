import os
import re
import random
from typing import List


def read_mcq_file(path: str) -> List[str]:
    with open(path) as f:
        return [line.strip() for line in f.readlines() if line.strip() != ""]


def clean_data(txt: List[str]) -> List[str]:
    return [line for line in txt if re.match(r"^(([0-9]*[.(])|([a-z][.)]))", line)]


def generate_shuffled_md(path: str, txt: List[str]) -> None:
    i = 0
    j = 1
    with open(path, "w") as file:
        while i < len(txt):
            file.write(str(j) + txt[i].lstrip("1234567890"))
            j += 1
            i += 1
            _choices = []
            while i < len(txt):
                if not re.match(r"^([a-z][.)])", txt[i]):
                    break
                _choices.append(txt[i])
                i += 1
            random.shuffle(_choices)
            for k, _choice in enumerate(_choices):
                file.write("\n\t" + chr(ord("a") + k) + _choice[1:])
            file.write("\n\n")


if __name__ == '__main__':
    data_folder = "data"
    results_folder = "results"
    data = []
    for filename in os.listdir(data_folder):
        filepath = os.path.join(data_folder, filename)
        data.append([os.path.join(results_folder, filename), read_mcq_file(filepath)])

    for filepath, text in data:
        generate_shuffled_md(filepath, clean_data(text))
