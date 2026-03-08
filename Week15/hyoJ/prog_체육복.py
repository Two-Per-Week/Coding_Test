def solution(n, lost, reserve):
    have = [True] * n
    for i in range(len(have)):
        if i + 1 in lost:
            have[i] = False
        if not have[i] and i + 1 in reserve:
            reserve.remove(i + 1)
            have[i] = True
    
    lost.sort()
    reserve.sort()
    
    for i in lost:
        if have[i - 1]:
            continue
        if i - 1 in reserve:
            reserve.remove(i - 1)
            have[i - 1] = True
        elif i + 1 in reserve:
            reserve.remove(i + 1)
            have[i - 1] = True
    return sum(have)
