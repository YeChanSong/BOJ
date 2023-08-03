import sys

def gkstn(n):
    tmp = str(n)
    if len(tmp) <3:
        return n
    cnt = 99
    for i in range(100,n+1):
        tmp = str(i)
        if int(tmp[0]) - int(tmp[1]) == int(tmp [1]) - int(tmp[2]):
            cnt += 1
    return cnt

init = int(sys.stdin.readline().strip())
print(gkstn(init))
