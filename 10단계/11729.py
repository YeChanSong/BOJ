import sys
sys.setrecursionlimit(1000000)
'''
5개의 판이 있는 경우.
3번 기둥에 5판이 들어오려면 2번 기둥에 4321판이 들어있어야 한다.
2번 기둥에 4판이 들어오려면 3번 기둥에 321판이 들어있어야 한다.
3번 기둥에 3판이 들어오려면 2번 기둥에 21판이 들어있어야 한다.
2번 기둥에 2판이 들어오려면 1번 기둥에 1판이 들어있어야 한다.

3번 기둥에 54321판이 놓이려면 3단계를 거쳐야 한다.
1. 4321판이 2번 기둥에 들어간다.
2. 5판이 3번 기둥으로 들어간다.
3. 4321판이 3번 기둥으로 들어간다.

트리 중위순회처럼 동작한다.
'''

def recur(start,end,plate):
    global hist
    if plate == 0:
        return
    tmp = 6 - start - end
    # 1단계
    recur(start,tmp,plate-1)
    # 2단계
    hist.append((start,end))
    # 3단계
    recur(tmp,end,plate-1)
    
n = int(sys.stdin.readline().strip())
hist = []

recur(1,3,n)
print(2**n - 1)
for s,e in hist:
    print(s,e)
