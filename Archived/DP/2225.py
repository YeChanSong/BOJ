import sys

N,K = map(int,sys.stdin.readline().split())
cache = list([-1 for i in range(N+1)] for j in range(K+1))

cache[1] = list(1 for i in range(N+1))
for i in range(2,K+1):
    cache[i][0] = 1
    for j in range(1,N+1):
        cache[i][j] = (cache[i-1][j]%1000000000+cache[i][j-1]%1000000000)%1000000000
print(cache[K][N]%1000000000)