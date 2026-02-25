import heapq

def clean_hp(hp, visited):
    while hp and not visited[hp[0][1]]:
        heapq.heappop(hp)

def clean_hp_max(hp_max, visited):
    while hp_max and not visited[hp_max[0][1]]:
        heapq.heappop(hp_max)

def solution(operations):
    hp, hp_max = [], []
    visited = [False] * len(operations)
    for i, j in enumerate(operations):
        x, y = j.split()
        if x == "I":
            heapq.heappush(hp, (int(y), i))
            heapq.heappush(hp_max, (-int(y), i))
            visited[i] = True
            continue

        if not hp or x != "D":
            continue

        if y == "1":
            clean_hp_max(hp_max, visited)
            if not hp_max:
                continue
            visited[hp_max[0][1]] = False
            heapq.heappop(hp_max)
        else:
            clean_hp(hp, visited)
            if not hp:
                continue
            visited[hp[0][1]] = False
            heapq.heappop(hp)
    
    clean_hp(hp, visited)
    clean_hp_max(hp_max, visited)
    return [-hp_max[0][0], hp[0][0]] if hp or hp_max else [0, 0]
