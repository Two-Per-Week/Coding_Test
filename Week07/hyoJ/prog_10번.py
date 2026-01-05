def solution(snippet, message):
    answer = []
    dic = {}
    for i, j in snippet:
        dic[i] = j
    for i in message.split():
        answer.append(dic[i] if i in dic else i)
    return ' '.join(answer)
