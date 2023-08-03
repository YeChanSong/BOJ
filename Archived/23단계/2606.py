import sys

def buildGraph():
    global adj
    E = int(sys.stdin.readline().strip())
    for i in range(E):
        s,d = map(int,sys.stdin.readline().strip().split())
        adj[s-1].append(d-1)
        adj[d-1].append(s-1)

def dfs(idx):
    global adj, visited, cnt
    
    visited[idx] = True
    cnt +=1
    for i in adj[idx]:
        if visited[i] == False:
            dfs(i)
            
N = int(sys.stdin.readline().strip())
global adj, visited, cnt
cnt = 0
adj = list([] for i in range(N))
visited = list(False for i in range(N))
buildGraph()
dfs(0)
print(cnt-1)
