import sys

N = int(sys.stdin.readline().strip())
cache = list(None for i in range(N+1))
cache[1] = 0
for idx in range(2,N+1):
    a,b,c = 987654321,987654321,987654321
    if idx%3 == 0:
        a = cache[idx//3] +1
    
    if idx%2 == 0:
        b = cache[idx//2] +1
        
    c = cache[idx-1] +1
    cache[idx] = min(a,b,c)
    
print(cache[N])
