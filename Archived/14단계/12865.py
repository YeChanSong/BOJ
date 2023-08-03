import sys

N, K = map(int,sys.stdin.readline().strip().split())
li = []
for i in range(N):
    w,v = map(int,sys.stdin.readline().strip().split())
    li.append((w,v))
cache = [[0 for i in range(K+1)] for j in range(N+1)]

for n in range(1,N+1):
    w,v = li[n-1][0], li[n-1][1]
    for k in range(1,K+1):
        if w > k:
            cache[n][k] = cache[n-1][k]
            continue
        
        cache[n][k] = max(cache[n-1][k], v + cache[n-1][k-w])
print(cache[N][K])