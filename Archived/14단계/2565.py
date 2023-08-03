import sys
sys.setrecursionlimit(100000)

def recur(idx):
    # 겹치는 전선 없이 최대로 연결 할 수 있는 수를 반환
    global cache, pillar

    if cache[idx] != 0:
        return cache[idx]
    
    cnt = 1
    # 자신을 연결할 것이므로 시작은 1
    for i in range(idx+1,len(pillar)):
        if pillar[idx][1] < pillar[i][1]:
            cnt = max(cnt,recur(i)+1)
    cache[idx] = cnt
    return cnt    

N = int(sys.stdin.readline().strip())
pillar = []
cache = list(0 for i in range(N))
for i in range(N):
    pillar.append(tuple(map(int,sys.stdin.readline().strip().split())))
pillar = sorted(pillar)
ans = 0
for i in range(N):
    ans = max(ans,recur(i))
print(N-ans)