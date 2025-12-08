import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while True:
        x = heapq.heappop(scoville)
        if K <= x or not scoville:
            heapq.heappush(scoville, x)
            break
        y = heapq.heappop(scoville)
        heapq.heappush(scoville, x + y * 2)
        answer += 1
    return answer if scoville[0] >= K else -1
