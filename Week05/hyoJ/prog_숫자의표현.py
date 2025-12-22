def solution(n):
    answer = 0
    arr = [i for i in range(1, n+1)]
    start, end = 0, 0
    while end < n:
        s = sum(arr[start:end + 1])
        if s == n:
            answer += 1
        if s >= n:
            start += 1
            end = start
        else:
            end += 1
    return answer
