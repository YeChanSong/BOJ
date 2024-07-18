import sys, heapq
INF = 10**300
def dijkstra(iy,ix):
    global board,M,N
    pq = list()
    dist = list([INF for i in range(M)] for j in range(N))
    heapq.heappush(pq,(0,iy,ix))
    dist[iy][ix] = 0
    X = [1,-1,0,0]
    Y = [0,0,1,-1]
        
    while pq:
        cost, y, x = heapq.heappop(pq)
        if cost>dist[y][x]:
            continue
        
        for i in range(4):
            tmpy, tmpx = y+Y[i],x+X[i]
            if tmpy<0 or tmpy>=N or tmpx<0 or tmpx>=M:
                continue
            if dist[tmpy][tmpx] > cost+board[tmpy][tmpx]:
                dist[tmpy][tmpx] = cost+board[tmpy][tmpx]
                heapq.heappush(pq,(cost+board[tmpy][tmpx],tmpy,tmpx))
    return dist        

M,N = map(int,sys.stdin.readline().strip().split())
board = list()
for i in range(N):
    board.append(list(map(int,sys.stdin.readline().strip())))
ans = dijkstra(0,0)
print(ans[N-1][M-1])