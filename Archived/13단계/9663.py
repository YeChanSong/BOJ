import sys
# pypy3로 실행
def recur(y,x):
    global N,hist,cnt
    # 스택으로 사용할 리스트 hist
    # 퀸을 겹치지 않게 두는 방법의 수 cnt
    # 체스 판에서의 위치정보 y,x
    hist.append((y,x))
    
    if N == len(hist):
        cnt+=1
        hist.pop()
        return
    
    for k in range(N):
        flag = True
        # 20 - 23라인의 조건문을 재귀 첫 부분에 둔 경우 시간초과 발생
        # 재귀를 생성해주는 현재의 부분에서 공격 범위에 들어가는지를 판별해서
        # 약간이나마 시간을 절약
        for i in hist:
            if i[0] == y+1 or i[1] == k or abs(y+1-i[0]) == abs(k-i[1]):
                flag = False
                break
        if flag == True:
            recur(y+1,k)

    hist.pop()
    
N = int(sys.stdin.readline().strip())
hist = list()
cnt = 0
for i in range(N):
    recur(0,i)
print(cnt)
