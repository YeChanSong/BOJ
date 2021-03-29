import sys

N = int(sys.stdin.readline().strip())
board = list()
for i in range(N):
    board.append(list(sys.stdin.readline().strip()))
X=[1,-1,0,0]
Y=[0,0,1,-1]
cnt = 0
for y in range(N):
    for x in range(N):
        for i in range(4):
            if not(0<=y+Y[i]<N and 0<=x+X[i]<N):
                continue
            board[y][x], board[y+Y[i]][x+X[i]] = board[y+Y[i]][x+X[i]], board[y][x]
            tmp = 0
            bef = board[y][0]
            for k in range(N):
                if board[y][k] == bef:
                    tmp += 1
                else:
                    cnt = max(cnt,tmp)
                    tmp = 1; bef = board[y][k]
                cnt = max(cnt,tmp)
            tmp =0
            bef = board[y+Y[i]][0]
            for k in range(N):
                if board[y+Y[i]][k] == bef:
                    tmp += 1
                else:
                    cnt = max(cnt,tmp)
                    tmp = 1; bef = board[y+Y[i]][k]
                cnt = max(cnt,tmp)
            tmp =0
            bef = board[0][x]
            for k in range(N):
                if board[k][x] == bef:
                    tmp += 1
                else:
                    cnt = max(cnt,tmp)
                    tmp = 1; bef = board[k][x]
                cnt = max(cnt,tmp)
            tmp =0
            bef = board[0][x+X[i]]
            for k in range(N):
                if board[k][x+X[i]] == bef:
                    tmp += 1
                else:
                    cnt = max(cnt,tmp)
                    tmp = 1; bef = board[k][x+X[i]]
                cnt = max(cnt,tmp)
            board[y][x], board[y+Y[i]][x+X[i]] = board[y+Y[i]][x+X[i]], board[y][x]
print(cnt)
