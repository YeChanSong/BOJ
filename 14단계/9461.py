import sys

def recur(idx):
    global Plist
    
    if Plist[idx] != None:
        return Plist[idx]

    tmp = recur(idx-2) + recur(idx-3)
    Plist[idx] = tmp
    return tmp

C = int(sys.stdin.readline().strip())
for i in range(C):
    N = int(sys.stdin.readline().strip())
    Plist = [None for i in range(N+3)]
    Plist[1],Plist[2],Plist[3] = 1,1,1
    ans = recur(N)
    print(ans)