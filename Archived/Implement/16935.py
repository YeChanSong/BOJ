import sys

N,M,R = map(int,sys.stdin.readline().split())
board = list()
for i in range(N):
    board.append(list(map(int,sys.stdin.readline().split())))
keys = list(map(int,sys.stdin.readline().split()))
for t in range(R):
    key = keys[t%len(keys)]
    if key == 1:
        n = len(board)
        for i in range(n//2):
            board[i],board[n-1-i] = board[n-1-i],board[i]
    elif key == 2:
        n = len(board)
        for i in range(n):
            board[i] = board[i][::-1]
    elif key == 3:
        tmp = board.copy()
        n,m = len(tmp),len(tmp[0])
        board = list([0 for i in range(n)] for j in range(m))
        for i in range(n):
            for j in range(m):
                board[j][n-1-i] = tmp[i][j]
    elif key == 4:
        tmp = board.copy()
        n,m = len(tmp),len(tmp[0])
        board = list([0 for i in range(n)] for j in range(m))
        for i in range(n):
            for j in range(m):
                board[m-1-j][i] = tmp[i][j]
    elif key == 5:
        a,b,c,d = list(),list(),list(),list()
        n,m = len(board)//2,len(board[0])//2
        for i in range(n):
            a.append(board[i][:m])
            b.append(board[i][m:])
        for i in range(n,len(board)):
            c.append(board[i][:m])
            d.append(board[i][m:])
        for i in range(n):
            board[i] = c[i]+a[i]
        for i in range(n,len(board)):
            board[i] = d[i-n]+b[i-n]
    else:
        a,b,c,d = list(),list(),list(),list()
        n,m = len(board)//2,len(board[0])//2
        for i in range(n):
            a.append(board[i][:m])
            b.append(board[i][m:])
        for i in range(n,len(board)):
            c.append(board[i][:m])
            d.append(board[i][m:])
        for i in range(n):
            board[i] = b[i]+d[i]
        for i in range(n,len(board)):
            board[i] = a[i-n]+c[i-n]
for i in board:
    print(' '.join(map(str,i)))
