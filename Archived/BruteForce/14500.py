import sys

N, M = map(int,sys.stdin.readline().strip().split())
board = list()
for i in range(N):
    board.append(list(map(int,sys.stdin.readline().strip().split())))

mxsm = 0
# 2x3
for i in range(N-1):
    for j in range(M-2):
        # L
        a = board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j]
        b = board[i][j] + board[i+1][j+1] + board[i+1][j+2] + board[i+1][j]
        a1 = a - board[i+1][j] + board[i+1][j+2]
        b1 = b - board[i][j] + board[i][j+2]
        # ㅗ
        c = a - board[i+1][j] + board[i+1][j+1]
        d = b - board[i][j] + board[i][j+1]
        # ㅁ
        e = board[i][j] + board[i+1][j] + board[i][j+1] + board[i+1][j+1]
        f = board[i][j+1] + board[i+1][j+1] + board[i][j+2] + board[i+1][j+2]
        # Z
        g = e - board[i+1][j]+board[i+1][j+2]
        h = f - board[i+1][j+2] + board[i+1][j]
        mxsm = max(mxsm,a,b,a1,b1,c,d,e,f,g,h)
# 3x2
for i in range(N-2):
    for j in range(M-1):
        # L
        a = board[i][j] + board[i][j+1] + board[i+1][j] + board[i+2][j]
        b = board[i+2][j] + board[i+2][j+1] + board[i+1][j+1] + board[i][j+1]
        a1 = a - board[i][j+1] + board[i+2][j+1]
        b1 = b - board[i+2][j] + board[i][j]
        # ㅗ
        c = a - board[i][j+1] + board[i+1][j+1]
        d = b - board[i+2][j] + board[i+1][j]
        # Z
        e = c - board[i+2][j] + board[i+2][j+1]
        f = d - board[i+2][j+1] + board[i+2][j]
        mxsm = max(mxsm,a,b,a1,b1,c,d,e,f)

# ㅣ,ㅡ 
for i in range(N):
    for j in range(M-3):
        a = board[i][j] + board[i][j+1] + board[i][j+2] + board[i][j+3]
        mxsm = max(a, mxsm)
for i in range(N-3):
    for j in range(M):
        a = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+3][j]
        mxsm = max(a,mxsm)
print(mxsm)