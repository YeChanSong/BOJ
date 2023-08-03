import sys, collections

N,M = map(int,sys.stdin.readline().split())
board = list()
for i in range(N):
    board.append(sys.stdin.readline().strip())
    
def bfs():
    global board,N,M
    dist = list([-1 for i in range(M)] for j in range(N))
    q = collections.deque()
    q.append((0,0))
    dist[0][0] = 1
    X = [1,-1,0,0]; Y = [0,0,1,-1]
    while q:
        y,x = q.popleft()
        
        for i in range(4):
            dy, dx = y+Y[i], x+X[i]
            if not (0<=dy<N and 0<=dx<M):
                continue
            if board[dy][dx] == '1' and dist[dy][dx] == -1:
                q.append((dy,dx))
                dist[dy][dx] = dist[y][x]+1
    print(dist[N-1][M-1])
bfs()