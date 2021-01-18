import sys, collections
sys.setrecursionlimit(100000)
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