import sys

N = int(sys.stdin.readline().strip())
cache = list([-1 for i in range(10)] for j in range(N))
cache[N-1] = [1 for i in range(10)]
for i in range(N-2,-1,-1):
    cache[i][9] = cache[i+1][9]
    for j in range(8,-1,-1):
        cache[i][j] = (cache[i+1][j]%10007+cache[i][j+1]%10007)%10007

sm = 0
for i in range(10):
    sm = (sm%10007+ cache[0][i]%10007)%10007
print(sm)