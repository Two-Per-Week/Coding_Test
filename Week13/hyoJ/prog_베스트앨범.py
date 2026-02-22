def solution(genres, plays):
    answer = []
    dic, dic_sum = {}, {}
    for i, j in enumerate(genres):
        if j not in dic:
            dic[j] = []
            dic_sum[j] = 0
        dic[j].append([plays[i], i])
        dic_sum[j] += plays[i]
    for i in dic:
        dic[i] = sorted(dic[i], key = lambda x : (x[0], -x[1]), reverse = True)[:2]
    dic_sum = sorted(dic_sum, key = lambda x : dic_sum[x], reverse = True)
    for i in dic_sum:
        answer += [j[1] for j in dic[i]]
    return answer
