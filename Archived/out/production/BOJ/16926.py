import sys

N,M,R = map(int,sys.stdin.readline().split())
board = list()
for i in range(N):
    board.append(list(map(int,sys.stdin.readline().split())))
for t in range(R):
    for i in range(min(N,M)//2):
        tmp = board[i][i]
        for j in range(i,M-1-i):
            # 위
            board[i][j] = board[i][j+1]
            
        for j in range(i,N-1-i):
            # 오른쪽
            board[j][M-i-1] = board[j+1][M-i-1]
            
        for j in range(M-i-1,i,-1):
            # 아래
            board[N-1-i][j] = board[N-1-i][j-1]
            
        for j in range(N-1-i,i,-1):
            # 왼쪽
            board[j][i] = board[j-1][i]
            
        board[i+1][i] = tmp
for k in range(N):
    print(' '.join(map(str,board[k])))
