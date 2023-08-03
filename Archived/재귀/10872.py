import sys
sys.setrecursionlimit(10000000)

def recur(ttl,n,N):
    if N == 0:
        return 1
    if n == N:
        return ttl*n
    return recur(ttl*n,n+1,N)

N = int(sys.stdin.readline().strip())
print(recur(1,1,N))
