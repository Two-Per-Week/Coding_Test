def solution(s):
    answer = 0
    arr = []
    x, y = 0, 0
    for i in s:
        if not arr or i == arr[0]:
            x += 1
        else:
            y += 1
        arr.append(i)
        if x == y:
            arr = []
            x, y = 0, 0
            answer += 1
    return answer + 1 if arr else answer
