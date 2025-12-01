def solution(arr):
    answer = []
    for i in arr:
        if (not answer) or (answer and answer[-1] != i):
            answer.append(i)
    return answer
