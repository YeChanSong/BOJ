import sys

N = int(sys.stdin.readline().strip())
if N == 1:
    print(3)
    sys.exit()
cache = [0 for i in range(N)]
ans = 1;cache[0] = 1; cache[1] = 2
for j in range(2,N):
    cache[j] = ((cache[j-1]*2)%9901 + cache[j-2]%9901)%9901
    
for i in cache:
    ans = (ans%9901 + i%9901 + i%9901)%9901
print(ans%9901)