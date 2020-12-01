import sys
sys.setrecursionlimit(1000000)

dic = dict()
dic = {k:-1 for k in 'abcdefghijklmnopqrstuvwxyz'}
def recur(init,idx):
    global dic
    if idx == len(init):
        return 0

    if dic[init[idx]] == -1:
        dic[init[idx]] = idx
    
    recur(init,idx+1)
    
init = sys.stdin.readline().strip()
recur(init,0)
for i,v in dic.items():
    print(v,end=' ')


