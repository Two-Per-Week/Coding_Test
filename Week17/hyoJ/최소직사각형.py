def solution(sizes):
    answer = [0, 0]
    for s in sizes:
        answer = [max(max(s), answer[0]), max(min(s), answer[1])]
    return answer[0] * answer[1]
