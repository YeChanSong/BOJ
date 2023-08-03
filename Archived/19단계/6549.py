import sys

def findMax(left,right):
    global fences
    
    if left == right:
        return fences[left]
    
    mid = (left + right)//2
    ret = max(findMax(left,mid),findMax(mid+1,right))
    l = mid
    r = mid+1
    currh = min(fences[l],fences[r])
    ret = max(ret, currh*2)
    while l>left or r<right:
        
        if l > left and (r == right or fences[r+1] < fences[l-1]):
            l -=1
            currh = min(currh, fences[l])
        else:
            r +=1
            currh = min(currh, fences[r])
        
        ret = max(ret, currh * (r-l+1))
    return ret
    
while 1:
    fence = sys.stdin.readline().strip()
    if fence == '0':
        break
    fences = list(map(int,fence.split()))[1:]
    ans = findMax(0,len(fences)-1)
    print(ans)