import heapq

def solution(jobs):
    answer, tm, idx, cnt = 0, 0, 0, 0
    hq = []
    jobs.sort()
    while cnt < len(jobs):
        while idx < len(jobs) and jobs[idx][0] <= tm:
            start, do = jobs[idx]
            heapq.heappush(hq, [do, start, idx])
            idx += 1
        if not hq:
            tm += 1
            continue
        do_tm, start_tm, ix = heapq.heappop(hq)
        tm += do_tm
        answer += tm - start_tm
        cnt += 1
    return answer // len(jobs)
