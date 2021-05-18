import sys

N = int(sys.stdin.readline().strip())
li = list(); cache = list([0 for i in range(2)] for i in range(N))

for i in range(N):
    li.append(int(sys.stdin.readline().strip()))
if N==1:
    print(li[0])
    sys.exit()
cache[0][0] = li[0]; cache[1][0] = cache[0][0]+li[1]; cache[1][1] = cache[0][0]

for i in range(2,N):
    cache[i][0] = max(cache[i-2][1] + li[i-1],cache[i-1][1])+li[i]
    cache[i][1] = max(cache[i-1])
print(max(cache[N-1]))