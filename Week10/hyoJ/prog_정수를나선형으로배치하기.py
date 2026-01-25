def solution(n):
    answer = [[0 for _ in range(n)] for _ in range(n)]
    dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
    x, y, mode, start = 0, 0, 0, 1
    answer[x][y] = start
    start += 1
    while start <= n * n:
        move_x, move_y = x + dx[mode], y + dy[mode]
        if move_x < 0 or move_x >= n or move_y < 0 or move_y >= n or answer[move_x][move_y] != 0:
            mode = 1 if mode == 0 else (2 if mode == 1 else (3 if mode == 2 else 0))
            move_x, move_y = x, y
            continue
        answer[move_x][move_y] = start
        start += 1
        x, y = move_x, move_y
    return answer
