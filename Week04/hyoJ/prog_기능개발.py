import math

def solution(progresses, speeds):
    answer = []
    stk = []
    days = 0
    for i, p in enumerate(progresses):
        x = math.ceil((100 - p) / speeds[i])
        if not stk:
            stk.append(x)
        elif stk[-1] < x:
            stk.append(x)
            answer.append(days)
            days = 0
        days += 1
    answer.append(days)
    return answer
