def solution(s):
    s = s.split(' ')
    answer = sorted(list(map(int, s)))
    return ' '.join([str(answer[0]), str(answer[-1])])
