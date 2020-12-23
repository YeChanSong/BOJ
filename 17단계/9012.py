import sys

T = int(sys.stdin.readline().strip())
for i in range(T):
    ps = sys.stdin.readline().strip()
    stack = list()
    flag = True
    for j in ps:
        if j == '(':
            stack.append(j)
            continue
        else:
            if len(stack) == 0:
                flag = False
                break
            if stack[-1] == '(':
                stack.pop()
    if len(stack) != 0:
        flag = False
    
    if flag == True:
        print("YES")
    else:
        print("NO")