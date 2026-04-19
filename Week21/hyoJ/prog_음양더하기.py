def solution(absolutes, signs):
    answer = 0
    for i, j in zip(absolutes, signs):
        answer += i if j else -1 * i
    return answer
