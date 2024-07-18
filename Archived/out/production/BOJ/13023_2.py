import sys
sys.setrecursionlimit(2000)
N,M = map(int,sys.stdin.readline().split())
adj = list([] for i in range(N))
for i in range(M):
    s,d = map(int,sys.stdin.readline().split())
    adj[s].append(d)
    adj[d].append(s)

def dfs(idx,cnt):
    global adj,visited
    
    visited[idx] = True
    if cnt == 5:
        print(1)
        sys.exit()

    for i in adj[idx]:
        if visited[i]:
            continue
        dfs(i,cnt+1)
    visited[idx] = False
    
for i in range(N):
    visited = list(False for i in range(N))
    dfs(i,1)
print(0)