import sys

def dfs(cnt,team,idx):
    global ability, N, mn

    if cnt == N//2:
        tmp = 0
        for i in team:
            for j in team:
               tmp += ability[i][j]
        oppo = [i for i in range(N) if i not in team]
        ttmp = 0
        for i in oppo:
            for j in oppo:
                ttmp += ability[i][j]
        
        if abs(tmp-ttmp) < mn:
            mn = abs(tmp-ttmp)
            if mn == 0:
                return True
        return False
    
    # idx부터 시작해서 중복되는 팀 구성을 제외한다.
    for i in range(idx,N):
        if i not in team:
            team.append(i)
            if dfs(cnt+1,team,i):
                return True
            team.remove(i)
        

N = int(sys.stdin.readline().strip())
ability = []
for i in range(N):
    ability.append(list(map(int,sys.stdin.readline().strip().split())))
mn = 987654321
dfs(0,[],0)
print(mn)
    