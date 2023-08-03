import sys

def recur(y,x):
    global cache
    if x < 0 or x > 9:
        return 0
    
    if y == 1:
        return 1
    
    if x == 0:
        return recur(y-1,x+1)
    
    if x == 9:
        return recur(y-1,x-1)
    
    
    if cache[y][x] != None:
        return cache[y][x]
    
    tmp = (recur(y-1,x-1)%1_000_000_000 + recur(y-1,x+1)%1_000_000_000)%1_000_000_000
    cache[y][x] = tmp
    
    return tmp

N = int(sys.stdin.readline().strip())
cache = [[None for i in range(9)] for j in range(N+1)]
cache[1] = [1 for i in range(9)]
ans = 0
for i in range(9):
    ans += recur(N,i)

# 마지막 출력단계에서도 꼭 나머지 연산을 취해주자..
print(ans%1_000_000_000)
