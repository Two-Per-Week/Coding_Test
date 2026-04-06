def solution(s):
    answer = ''
    total_idx = 0
    idx = 0
    while total_idx < len(s):
        if s[total_idx] == ' ':
            answer += s[total_idx]
            idx = 0
        else:
            if idx % 2 == 0:
                answer += s[total_idx].upper()
            else:
                answer += s[total_idx].lower()
            idx += 1
        total_idx += 1
    return answer
