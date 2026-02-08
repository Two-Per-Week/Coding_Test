def solution(clothes):
    dic = {}
    for i in clothes:
        if i[1] not in dic:
            dic[i[1]] = 1
            continue
        dic[i[1]] += 1
    answer = 1
    for i in dic:
        answer *= (dic[i] + 1)
    return answer - 1
