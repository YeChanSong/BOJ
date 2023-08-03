import sys, heapq

def dijkstra(src):
    hq = list()
    heapq.heappush(hq,(0,src))
    dist[src] = 0
    
    while hq:
        cost,here = heapq.heappop(hq)
        if dist[here] < cost:
            continue
        for d,c in adj[here]:
            nxtdist = cost+c
            if dist[d]>nxtdist:
                dist[d] = nxtdist
                heapq.heappush(hq,(nxtdist,d))

V,E = map(int,sys.stdin.readline().strip().split())
S = int(sys.stdin.readline().strip())-1
INF = 10**300
adj = list([] for i in range(V))
dist = list(INF for i in range(V))
for i in range(E):
    s,d,c = map(int,sys.stdin.readline().strip().split())
    adj[s-1].append((d-1,c))
dijkstra(S)
for i in dist:
    if i == INF:
        print("INF")
    else:
        print(i)