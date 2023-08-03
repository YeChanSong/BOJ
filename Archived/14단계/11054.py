import sys
sys.setrecursionlimit(100000)

def LIS(idx):
    '''
    LIS함수는 idx를 기준으로 왼쪽에서 LIS의 길이를 반환
    '''
    global cache, array, N
    
    if cache[idx][0] != None:
        return cache[idx][0]
    
    mx = 0
    for i in range(idx-1,-1,-1):
        if array[idx] > array[i]:
            mx = max(mx, LIS(i)+1)
    cache[idx][0] = mx
    return mx

def LDS(idx):
    '''
    LDS함수는 idx를 기준으로 오른쪽에서 LDS의 길이를 반환
    '''
    global cache, array, N
    
    if cache[idx][1] != None:
        return cache[idx][1]
    
    mx = 0
    for i in range(idx+1,N):
        if array[idx] > array[i]:
            mx = max(mx, LDS(i)+1)
    cache[idx][1] = mx
    return mx
    
N = int(sys.stdin.readline().strip())
array = list(map(int,sys.stdin.readline().strip().split()))
cache = list([None,None] for i in range(N))
for i in range(N):
    LIS(i)
    LDS(i)
maximum = -1
for i in cache:
    tmp = i[0] + i[1]
    if maximum < tmp:
        maximum = tmp
print(maximum+1)

