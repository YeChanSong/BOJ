import sys

N,M,R = map(int,sys.stdin.readline().split())
board = list()
for i in range(N):
    board.append(list(map(int,sys.stdin.readline().split())))
    

for i in range(min(M,N)//2):
    q = list(); div = (2*(M+N-4*i)-4) # number of items
    diff = R%div
    for j in range(i,N-i-1):
        q.append(board[j][i])
    for j in range(i,M-i-1):
        q.append(board[N-i-1][j])
    for j in range(N-i-1,i,-1):
        q.append(board[j][M-i-1])
    for j in range(M-i-1,i,-1):
        q.append(board[i][j])
    # set pos and items
    cnt = (div - diff)%div
    for j in range(i,N-i-1):
        board[j][i] = q[cnt]
        cnt +=1
        cnt%=div
    for j in range(i,M-i-1):
        board[N-i-1][j] = q[cnt]
        cnt +=1
        cnt%=div
    for j in range(N-i-1,i,-1):
        board[j][M-i-1] = q[cnt]
        cnt +=1
        cnt%=div
    for j in range(M-i-1,i,-1):
        board[i][j] = q[cnt]
        cnt +=1
        cnt%=div

for k in range(N):
    print(' '.join(map(str,board[k])))
