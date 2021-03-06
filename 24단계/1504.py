import sys
INF = 10**300
'''
heapq를 사용하지 않은 다익스트라.
간선이 V^2보다 많은 경우 heapq를 사용하면
시간이 조금 더 오래 걸린다.
heapq를 사용하지 않은 경우 시간복잡도는 O(|V^2|+|E|)이다.
pypy3 기준 296ms
'''
def dijkstra(src):
    global adj,V,E
    dist = list(INF for i in range(V))
    visited = list(False for i in range(V))
    
    dist[src] = 0
    
    while 1:
        closest = INF
        here = None
        for i in range(V):
            if dist[i] < closest and visited[i]==False:
                here = i
                closest = dist[i]
        if closest == INF:
            break
        
        visited[here] = True
        for there,cost in adj[here]:
            if visited[there]:
                continue
            cost += dist[here]
            dist[there] = min(dist[there],cost)
            
    return dist
    
V,E = map(int,sys.stdin.readline().strip().split())
adj = list([] for i in range(V))
for i in range(E):
    s,d,c = map(int,sys.stdin.readline().strip().split())
    adj[s-1].append((d-1,c))
    adj[d-1].append((s-1,c))
via1, via2 = map(int,sys.stdin.readline().strip().split())
ans = dijkstra(via1-1)
one2A, A2B, A2N = ans[0],ans[via2-1],ans[V-1]
ans2 = dijkstra(via2-1)
one2B, B2N = ans2[0],ans2[V-1]
routeA = one2A + A2B + B2N
routeB = one2B + A2B + A2N

if routeA >= INF and routeB >= INF:
    print(-1)
elif routeA<routeB:
    print(routeA)
else:
    print(routeB)