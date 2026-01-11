def solution(numbers):
    answer = ''
    numbers = sorted(map(str, numbers), key = lambda x : x * 3, reverse=True)
    answer = ''.join(numbers)
    return answer if int(answer) != 0 else '0'
