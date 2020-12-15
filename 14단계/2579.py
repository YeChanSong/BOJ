import sys

def recur(pos,jmp):
    global N, steps, cache
    
    if pos < 0:
        return 0
    
    # jmp가 1이면 다음 재귀는 2칸을, 2면 1,2칸 뛰는 것을 계산
    if jmp == 1 and cache[pos] != [None,None]:
        return max(cache[pos])
    
    if jmp == 2 and cache[pos][1] != None:
        return cache[pos][1]
    
    one = recur(pos-1,2) + steps[pos]
    two = recur(pos-2,1) + steps[pos]
    
    cache[pos] = [one,two]
    if jmp == 1:
        return max(one,two)
    else:
        return two
    
N = int(sys.stdin.readline().strip())
steps = [0]
cache = [[None, None] for i in range(N+1)]
# 캐시[0]은 1칸으로 넘어오는 경우 최댓값, 캐시[1]은 2칸으로 넘어오는 경우 최댓값
for i in range(N):
    steps.append(int(sys.stdin.readline().strip()))
cache[0] = [0,0]
ans = recur(N,1)
print(ans)