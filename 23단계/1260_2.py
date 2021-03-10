import collections, sys

def dfs(idx):
    global visited, dfsresult, adj
    visited[idx] = True
    dfsresult.append(idx+1)
    
    for i in adj[idx]:
        if visited[i]:
            continue
        dfs(i)

def bfs(N,start):
    q = collections.deque()
    q.append(start)
    discovered = list(False for i in range(N))
    discovered[start] = True
    while q:
        itm = q.popleft()
        bfsresult.append(itm+1)
        for i in adj[itm]:
            if discovered[i]:
                continue
            q.append(i)
            discovered[i] = True
            
N,M,V = map(int,sys.stdin.readline().strip().split())
adj = list([] for i in range(N))
for i in range(M):
    s,d = map(int,sys.stdin.readline().strip().split())
    adj[s-1].append(d-1)
    adj[d-1].append(s-1)
for i in adj:
    i.sort()
visited = list(False for i in range(N))
dfsresult = list()
bfsresult = list()
dfs(V-1)
bfs(N,V-1)
print(' '.join(map(str,dfsresult)))
print(' '.join(map(str,bfsresult)))