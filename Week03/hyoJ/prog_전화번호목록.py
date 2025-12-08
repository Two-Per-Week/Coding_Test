def solution(phone_book):
    answer = True
    arr = {}
    for i in phone_book:
        arr[i] = 1
    for i in phone_book:
        for j in range(len(i)):
            if i[:j] in arr:
                return False
    return answer
