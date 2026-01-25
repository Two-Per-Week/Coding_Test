def solution(priorities, location):
    answer = [[p, i] for i, p in enumerate(priorities)]    
    cnt = 1
    idx = 0
    while priorities:
        if idx == len(priorities) and priorities:
            idx = 0
        if max(priorities) == priorities[idx]:
            priorities.pop(idx)
            if answer[idx][1] == location:
                break
            answer.pop(idx)
            cnt += 1
            continue
        idx += 1
    return cnt
