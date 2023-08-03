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
    while l <= r:
        mid = int((l+r)/2)
        if arr[mid] == idx:
            return 1
        if arr[mid] < idx:
            l = mid+1
        else:
            r = mid-1
    
    return 0
N = int(sys.stdin.readline().strip())
arr = list(map(int,sys.stdin.readline().strip().split()))
M = int(sys.stdin.readline().strip())
trgt = list(map(int,sys.stdin.readline().strip().split()))
arr.sort()
for i in trgt:
    print(binSearch(i))
