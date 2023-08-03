import sys

cache = list(0 for i in range(1000001))
g = list(0 for i in range(1000001))

i = 1
while i <=1000000:
    j = 1
    while j*i <=1000000:
        g[i*j] +=i
        j+=1
    i+=1

for i in range(1,1000001):
    cache[i] = cache[i-1]+g[i]

T = int(sys.stdin.readline().strip())
for i in range(T):
    N = int(sys.stdin.readline().strip())
    print(cache[N])