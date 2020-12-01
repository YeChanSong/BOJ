import sys
sys.setrecursionlimit(1000000)

cache = [[None for i in range(1001)] for j in range(1668)]

def recur(N,cnt3,cnt5):
    
    if N - cnt3*3 - cnt5*5 == 0:
        return cnt3 + cnt5
    
    if N - cnt3*3 - cnt5*5 < 0:
        return -1
    
    if cache[cnt3][cnt5] != None:
        return cache[cnt3][cnt5]

    a = recur(N,cnt3+1,cnt5)
    b = recur(N,cnt3,cnt5+1)
    tmp = 0
    if a == -1 and b == -1:
        tmp = -1
    elif a > 0 and b > 0:
        tmp = min(a,b)
    else:
        tmp = max(a,b)
    cache[cnt3][cnt5] = tmp
    return tmp

N = int(sys.stdin.readline().strip())
print(recur(N,0,0))
