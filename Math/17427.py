import sys, math

N = int(sys.stdin.readline().strip())
ans = 0
for i in range(1,N+1):
    ans += i*math.floor(N/i)
print(ans)