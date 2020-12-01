import sys,math
C = int(sys.stdin.readline().strip())
for i in range(C):
    init = list(map(int,sys.stdin.readline().strip().split()))
    cho, baek= (init[0],init[1],init[2]), (init[3],init[4],init[5])
    dist = math.sqrt((cho[0] - baek[0])**2 +(cho[1] - baek[1])**2)
    
    if dist == 0 and cho[2] == baek[2]:
        # 두 원이 겹치는 경우
        print(-1)
    elif (dist == 0 and cho[2] != baek[2]) or ((cho[2]+baek[2]) < dist) or dist < cho[2] - baek[2] or dist < baek[2] - cho[2]:
        # 두 원의 좌표는 같지만 반지름이 다른 경우 or 두 원이 만나지 않는 경우
        print(0)
    elif (cho[2]+baek[2]) == dist or dist == baek[2] - cho[2] or dist == cho[2] - baek[2]:
        # 두 원이 접하는 경우
        print(1)
    else:
        # 두 원이 걸치는 경우
        print(2)
    
