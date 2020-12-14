import sys

# 무심코 재귀를 돌리면 사이사이 나머지 연산을 취해줘도 세그먼트 폴트가 나온다.

N = int(sys.stdin.readline().strip())
cache = [None for i in range(N+1)]
cache[1] = 1
if N > 1:
    cache[2] = 2
for i in range(3,N+1):
    cache[i] = (cache[i-1]%15746 + cache[i-2]%15746)%15746
    
print(cache[N])
