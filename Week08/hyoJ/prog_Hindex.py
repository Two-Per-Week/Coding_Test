def solution(citations):
    citations = sorted(citations, reverse=True)
    answer = []
    for i, j in enumerate(citations, start=1):
        answer.append(min(i, j))
    return max(answer)
