import sys

N,K = map(int,sys.stdin.readline().split())

cache = list([0 for i in range(N+1)] for j in range(K+1))
for i in range(N+1):
    cache[1][i] = 1

for i in range(2,K+1):
    for j in range(N+1):
        cache[i][j] = (cache[i][j-1]%10**9+cache[i-1][j]%10**9)%10**9
        
print(cache[K][N]%10**9)