from itertools import permutations

def cal(a):
    c = int(''.join(a))
    if c == 1:
        return 0
    for b in range(2, c):
        if c % b == 0:
            return 0
    return c

def solution(numbers):
    answer = []
    for i in range(1, len(numbers) + 1):
        x = list(permutations(numbers, i))
        for y in x:
            answer.append(cal(y))
    answer = list(set(answer))
    return len(answer) if answer[0] != 0 else len(answer) - 1
