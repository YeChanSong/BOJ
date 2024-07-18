import sys

N = int(sys.stdin.readline().strip())
ops = sys.stdin.readline().strip()
ans = list(-100 for i in range(N))
plus = list(i for i in range(1,11))
minus = list(-i for i in range(1,11))
S = list([None for i in range(N)] for j in range(N))
idx = 0
for i in range(N):
    for j in range(i,N):
       S[i][j] = ops[idx]
       idx +=1

def recur(idx):
    global ans, S
    if idx == N:
        print(' '.join(map(str,ans)))
        sys.exit()
        return
    
    if S[idx][idx] == '0':
        ans[idx] = 0
        recur(idx+1)
    elif S[idx][idx] == '-':
        for i in minus:
            tmp = i
            tmpflag = True
            for k in range(idx-1,-1,-1):
                tmp += ans[k]
                if (S[k][idx] == '-' and tmp<0) or (S[k][idx]=='0' and tmp == 0) or (S[k][idx]=='+' and tmp>0):
                   continue
                else:
                    tmpflag = False
                    break
            if tmpflag:
                ans[idx] = i
                recur(idx+1)
    else:
        for i in plus:
            tmp = i
            tmpflag = True
            for k in range(idx-1,-1,-1):
                tmp += ans[k]
                if (S[k][idx] == '-' and tmp<0) or (S[k][idx]=='0' and tmp == 0) or (S[k][idx]=='+' and tmp>0):
                   continue
                else:
                    tmpflag = False
                    break
            if tmpflag:
                ans[idx] = i
                recur(idx+1)
recur(0)
