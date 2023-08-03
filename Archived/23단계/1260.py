import sys, collections
sys.setrecursionlimit(10000)

def buildGraph(M):
    global adj
    for i in range(M):
        s,d = map(int,sys.stdin.readline().strip().split())
        adj[s-1].append(d-1)
        adj[d-1].append(s-1)

def dfs(idx):
    global adj, visited, trail
    visited[idx] = True
    trail.append(idx+1)
    for i in sorted(adj[idx]):
        if visited[i] == False:
            dfs(i)
    

def bfs(idx):
    global adj, discovered, trail
    
    q = collections.deque()
    q.append(idx)
    discovered[idx] = True
    
    while len(q):
        itm = q.popleft()
        
        for i in sorted(adj[itm]):
            if discovered[i] == False:
                q.append(i)
                discovered[i] = True
        trail.append(itm+1)

N,M,V = map(int,sys.stdin.readline().strip().split())
global adj, visited, discovered, trail
visited = list(False for i in range(N))
discovered = list(False for i in range(N))
adj = list([] for i in range(N))
trail = list()
buildGraph(M)
dfs(V-1)
trail = ' '.join(map(str,trail))
print(trail)
trail = list()
bfs(V-1)
trail = ' '.join(map(str,trail))
print(trail)
