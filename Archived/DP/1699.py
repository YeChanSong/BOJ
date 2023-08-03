import sys, math

N = int(sys.stdin.readline().strip())

cache = list(1 for i in range(N+1))
cache[0] = 0
for i in range(2,N+1):
    tmp = 987654321
    for j in range(1,math.floor(math.sqrt(i))+1):
        l = j**2
        tmp = min(tmp,cache[l]+cache[i-l])
    cache[i] = tmp
print(cache[N])
    