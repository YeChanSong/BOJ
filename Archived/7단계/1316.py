import sys
sys.setrecursionlimit(1000000)

def recur(words,idx):
    if len(words) == idx:
        return 0
    pool = set()
    tmp = ''
    flag = False
    for i in words[idx]:
        if tmp != i and i not in pool:
            tmp = i
            pool.add(tmp)
        if tmp != i and i in pool:
            flag = True
            break
    if flag == False:
        return 1 + recur(words,idx+1)
    else:
        return recur(words,idx+1)
        
C = sys.stdin.readline().strip()
words = []
for i in range(int(C)):
    tmp = sys.stdin.readline().strip()
    words.append(tmp)
print(recur(words,0))
