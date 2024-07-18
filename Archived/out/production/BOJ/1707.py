import sys, collections
sys.setrecursionlimit(100000)

'''
DFS로 연결 성분을 구해서 BFS를 시작할 정점들을 구한다.(cc)
모든 정점들이 연결되어 있지 않는 경우도 있을 수 있기 때문이다.

이후 각 연결 성분마다 BFS를 수행하며,
같은 부모를 가지고 있으면서 인접한 정점 == 시작 정점으로 부터 거리가 같고 인접한 정점을 발견하면
이분 그래프로 나눌 수 없으므로 NO를 출력하고 종료한다.

BFS를 수행해서 구할 수 있는 거리를 홀수, 짝수로 나누면 이분 그래프가 된다.
단, 같은 부모를 가지고 인접한 정점이 있을 경우 이분 그래프의 정의에 위배되므로 주의!
'''

def dfsall():
    global V, adj, visited
    cc = list()
    for i in range(V):
        if not visited[i]:
            cc.append(i)
            dfs(i)
    return cc

def dfs(idx):
    global adj, visited
    
    visited[idx] = True
    
    for i in adj[idx]:
        if not visited[i]:
            dfs(i)

def bfs(cc):
    global adj, V, distance
    q = collections.deque()
    for i in cc:
        q.append(i)
        distance[i] = 0
    
    while len(q):
        itm = q.popleft()
        cost = distance[itm]
        for i in adj[itm]:
            if distance[i] == -1:
                q.append(i)
                distance[i] = cost +1
            else:
                if distance[i] == distance[itm]:
                    print("NO")
                    return
    print("YES")

K = int(sys.stdin.readline().strip())
for i in range(K):
    global adj, V, E, distance, visited
    V,E = map(int,sys.stdin.readline().strip().split())
    distance = list(-1 for i in range(V))
    visited = list(False for i in range(V))
    adj = list([] for i in range(V))
    for j in range(E):
        s,d = map(int,sys.stdin.readline().strip().split())
        if s==d:
            continue
        adj[s-1].append(d-1)
        adj[d-1].append(s-1)
    cc = dfsall()
    bfs(cc)