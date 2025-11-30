def solution(nums):
    answer = min(len(nums) // 2, len(list(set(nums))))
    return answer
