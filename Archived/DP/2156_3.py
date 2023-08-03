import sys

N = int(sys.stdin.readline().strip())
li = list(); li.append(0);li.append(0)

for i in range(N):
    li.append(int(sys.stdin.readline().strip()))
cache = list([0,0] for i in range(N+2))
for i in range(2,N+2):
    cache[i][0] = max(cache[i-2][1] + li[i-1], cache[i-1][1]) + li[i]
    cache[i][1] = max(cache[i-1])

print(max(cache[N+1]))