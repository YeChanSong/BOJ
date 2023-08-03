import sys

N = int(sys.stdin.readline().strip())
li = list()
for i in range(N):
    li.append(list(map(int,sys.stdin.readline().split())))
team = list(False for i in range(N))

lim =1
mn = 987654321
def recur(idx,cnt):
    global mn
    if cnt == lim:
        T=0;F=0
        for i in range(N):
            for j in range(i+1,N):
                if team[i] == True and team[j] == True:
                    T += li[i][j]
                    T += li[j][i]
                    continue
                if team[i] == False and team[j] == False:
                    F += li[i][j]
                    F += li[j][i]
                    continue
        mn = min(mn,abs(T-F))
    for i in range(idx+1,N):
        team[i] = True
        recur(i,cnt+1)
        team[i] = False

for i in range(N-1):
    recur(0,0)
    lim += 1

print(mn)