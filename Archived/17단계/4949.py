import sys

while 1:
    data = sys.stdin.readline().rstrip()
    if len(data) == 1 and data[0] == '.':
        break
    stack = list()
    flag = True
    for i in data:
        if i not in ['(',')','[',']']:
            continue
        if i in ['(','[']:
            stack.append(i)
            continue
        else:
            if len(stack) == 0:
                flag = False
                break
            if (stack[-1] == '(' and i == ')') or (stack[-1] == '[' and i == ']'):
                stack.pop()
                continue
            else:
                flag = False
                break
    if len(stack) != 0:
        flag = False
    if flag == True:
        print("yes")
    else:
        print("no")