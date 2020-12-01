import sys, math
sys.setrecursionlimit(10000000)
def recur(l,jmp,stk,cnt):
    '''
    l: 거리
    jmp: 이동할 광년 수
    stk: 누적 이동거리
    cnt: 이동 횟수
    '''
    # 누적 이동거리의 2배가 최대 이동거리다.
    # ex> 
    # 12321  : 9광년까지는 5번의 점프 수가 최대
    # 123321 : 12광년까지는 6번의 점프 수가 최대
    # 1234321: 16광년까지는 7번의 점프 수가 최대
    # 즉, 이동할 광년 수를 2번씩 더해주면서 진행하면
    # 최대 이동거리를 알 수 있고, l이 범위 안에 있다면
    # 답은 cnt가 된다.
    # 1 11 121 1221 12321 123321 1234321 ---
    if stk >= l:
        return cnt
    
    if cnt%2 != 0:
        return recur(l,jmp+1,stk+jmp,cnt+1)
    else:
        return recur(l,jmp,stk+jmp,cnt+1)

C = int(sys.stdin.readline().strip())
for i in range(C):
    x,y = map(int,sys.stdin.readline().strip().split())
    # l은 시작점과 끝 점 사이의 거리
    l = y-x
    ans = recur(l,1,0,0)
    print(ans)
