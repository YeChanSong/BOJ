import sys
sys.setrecursionlimit(1000000)

def recur(numstr,idx):
    if idx == len(numstr):
        return 0
    return int(numstr[idx]) + recur(numstr,idx+1)

i = sys.stdin.readline().strip()
nstr = sys.stdin.readline().strip()
answer = recur(nstr,0)
print(answer)
