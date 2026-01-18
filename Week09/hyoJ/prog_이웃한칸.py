def solution(board, h, w):
    answer = 0
    x, y = [0, 1, -1, 0], [1, 0, 0, -1]
    for i in range(4):
        dx, dy = h + x[i], w + y[i]
        if dx < 0 or dx >= len(board) or dy < 0 or dy >= len(board[0]):
            continue
        if board[h][w] == board[dx][dy]:
            answer += 1
    return answer
