def cal(answers, r):
    return sum([answers[i] == r[i % len(r)] for i in range(len(answers))])

def solution(answers):
    r1 = [1, 2, 3, 4, 5]
    r2 = [2, 1, 2, 3, 2, 4, 2, 5]
    r3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    answer = [cal(answers, r1), cal(answers, r2), cal(answers, r3)]
    return [i + 1 for i, j in enumerate(answer) if j == max(answer)]
