import sys

N,M,y,x,K = map(int,sys.stdin.readline().split())

board = list()
for i in range(N):
    board.append(list(map(int,sys.stdin.readline().split())))
order = list(map(int,sys.stdin.readline().split()))
dice = list(0 for i in range(6))
# dice: top right left north south bottom
# order[k] --> dice = [dice[t] for t in moving[order[k]]]
moving = dict(zip([1,2,3,4],\
    [[2,0,5,3,4,1],[1,5,0,3,4,2],[4,1,2,0,5,3],[3,1,2,5,0,4]]))
X = [1,-1,0,0]
Y = [0,0,-1,1]
for k in order:
    if not (0<=y+Y[k-1]<N and 0<=x+X[k-1]<M):
        continue
    y += Y[k-1]; x+= X[k-1]
    dice = [dice[t] for t in moving[k]]
    if board[y][x] == 0:
        board[y][x] = dice[5]
    else:
        dice[5] = board[y][x]
        board[y][x] = 0
    print(dice[0])