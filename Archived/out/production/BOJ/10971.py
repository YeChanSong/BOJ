import sys

N = int(sys.stdin.readline().strip())
cost = list(list(map(int,sys.stdin.readline().split())) for i in range(N))
mn = 987654321; visited = list(False for i in range(N))
visited[0] = True
def recur(pos,bef,ttl):
    global mn, visited, cost
    if pos == N:
        if cost[bef][0] == 0:
            return
        mn = min(ttl+cost[bef][0],mn)
        return
    for i in range(1,N):
        if visited[i] or cost[bef][i] == 0:
            continue
        visited[i] = True
        recur(pos+1,i,ttl+cost[bef][i])
        visited[i] = False

recur(1,0,0)
print(mn)