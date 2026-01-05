def solution(times, n):
    answer = []
    for i in range(0, len(times) - n + 1):
        answer.append(sum(times[i:i+n]))
    return max(answer)
