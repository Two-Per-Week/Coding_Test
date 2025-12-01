def solution(s):
    arr = []
    for i in s:
        if i == '(':
            arr.append(i)
            continue
        if not arr:
            return False
        arr.pop()
    return False if arr else True
