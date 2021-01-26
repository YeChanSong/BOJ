#pypy3
import sys

def binSearch(idx):
    global arr
    l = 0
    r = len(arr)-1
    if l == r:
        if arr[l] == idx:
            return 1
        else:
            return 0
    flag = False
    mid = 0
    while l <= r:
        mid = int((l+r)/2)
        if arr[mid] == idx:
            flag = True
            break
        if arr[mid] < idx:
            l = mid+1
        else:
            r = mid-1
    
    if flag:
        cntr = 0
        ll,lr = l,mid
        rl,rr = mid,r
        while 1:
            if arr[ll] == idx:
                break
            mid = int((ll+lr)/2)
            
            if arr[mid] == idx:
                lr = mid-1
            else:
                ll = mid+1
        
        while 1:
            if arr[rr] == idx:
                break
            mid = int((rl+rr)/2)
            
            if arr[mid] == idx:
                rl = mid+1
            else:
                rr = mid-1
            
        cntr = rr - ll +1
        return cntr
    return 0

N = int(sys.stdin.readline().strip())
arr = list(map(int,sys.stdin.readline().strip().split()))
M = int(sys.stdin.readline().strip())
trgt = list(map(int,sys.stdin.readline().strip().split()))
arr.sort()
ans = list()
for i in trgt:
    ans.append(binSearch(i))
print(' '.join(map(str,ans)))
