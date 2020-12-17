import sys
sys.setrecursionlimit(100000)
def recur(idx):
    global cache, array, N
    
    if idx < 0:
        return
    
    mx = 0
    for i in range(idx+1,N):
        if array[idx] < array[i] and cache[i] > mx :
            mx = cache[i]
        
    cache[idx] = mx+1
    recur(idx-1)


N = int(sys.stdin.readline().strip())
array = list(map(int,sys.stdin.readline().strip().split()))
cache = list(0 for i in range(N))
recur(N-1)
print(max(cache))