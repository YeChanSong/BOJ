import sys, heapq

'''
지도에서 가장 높은 지점을 순서대로 뽑아 해당 지점 근처 4방향의 낮은 지점으로
가능한 경로의 수를 더해준다.

처음 위치는 시작점이므로 1을 주고 시작하며, 다른 위치는 0으로 시작한다.
따라서, 갈 수 없는 지점의 경우의 수는 0으로 고정되며 이동경로의 가짓수에 영향을
주지 않는다.

이때, 힙큐에 중복되어서 들어간 점을 제거하기 위해서 ly,lx를 사용한다.
'''

def dijkstra(iy,ix):
    global cost, H, W, cache
    
    pq = list()
    heapq.heappush(pq,(-cost[iy][ix],iy,ix))
    cache[iy][ix] = 1
    X = [1,-1,0,0]
    Y = [0,0,1,-1]
    ly, lx = -1,-1
    while pq:
        cst, y, x = heapq.heappop(pq)
        if ly == y and lx == x:
            continue
        ly, lx = y,x
        
        for i in range(4):
            tmpy, tmpx = y+Y[i], x+X[i]
            if tmpy<0 or tmpy>=H or tmpx<0 or tmpx>=W:
                continue
            
            if -cst > cost[tmpy][tmpx]:
                cache[tmpy][tmpx] += cache[y][x]
                heapq.heappush(pq,(-cost[tmpy][tmpx],tmpy,tmpx))

H,W = map(int,sys.stdin.readline().strip().split())
cost = list()
cache = list([0 for i in range(W)] for j in range(H))
for _ in range(H):
    cost.append(list(map(int,sys.stdin.readline().strip().split())))
    
dijkstra(0,0)
print(cache[H-1][W-1])