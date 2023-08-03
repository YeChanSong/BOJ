import sys, heapq
INF = 10**300

def dijkstra(src):
    global V,E,adj
    cost = list(INF for i in range(V))
    pq = list()
    heapq.heappush(pq,(0,src))
    cost[src] = 0
    
    while pq:
        curr,here = heapq.heappop(pq)
        
        for there,cst in adj[here]:
            cst += curr
            if cost[there] > cst:
                cost[there] = cst
                heapq.heappush(pq,(cst,there))
    return cost  

V,E = map(int,sys.stdin.readline().strip().split())
K = int(sys.stdin.readline().strip())-1
adj = list([] for i in range(V))
for i in range(E):
    u,v,w = map(int,sys.stdin.readline().strip().split())
    adj[u-1].append((v-1,w))
    
ans = dijkstra(K)
for i in ans:
    if i == INF:
        print('INF')
    else:
        print(i)