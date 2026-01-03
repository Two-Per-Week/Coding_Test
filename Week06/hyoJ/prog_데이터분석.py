def solution(data, ext, val_ext, sort_by):
    target = { 'code': 0, 'date': 1, 'maximum': 2, 'remain': 3 }
    answer = [i for i in data if i[target[ext]] < val_ext]
    answer = sorted(answer, key = lambda x : x[target[sort_by]])
    return answer
