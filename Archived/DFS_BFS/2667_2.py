import sys, collections

cnt = 0
total = list()
N = int(sys.stdin.readline().strip())
X = [1,-1,0,0]; Y = [0,0,1,-1]
board = list()
for i in range(N):
    board.append(sys.stdin.readline().strip())

dist = list(list(-1 for i in range(N)) for j in range(N))
def bfs(y,x):
    global board,X,Y,dist
    
    q = collections.deque()
    q.append((y,x))
    dist[y][x] = 0
    cntr = 1
    while q:
        itm = q.popleft()
        
        for i in range(4):
            dy,dx = itm[0]+Y[i],itm[1]+X[i]
            if not (0<= dy < N and 0<= dx <N):
                continue
            if board[dy][dx] == '1' and dist[dy][dx] == -1:
                q.append((dy,dx))
                cntr += 1
                dist[dy][dx] = dist[itm[0]][itm[1]]
    return cntr

def bfsall():
    global N,board,dist,cnt,total
    for y in range(N):
        for x in range(N):
            if board[y][x] == '1' and dist[y][x] == -1:
                total.append(bfs(y,x))
                cnt += 1
bfsall()
print(cnt)
for i in sorted(total):
    print(i)