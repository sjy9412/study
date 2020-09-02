# 이것이 코딩 테스트다
# 구현 4-1 상하좌우

n = int(input())

# L R U D
dir = {'L': [0, -1], 'R': [0, 1], 'U': [-1, 0], 'D': [1, 0]}

array = list(map(str, input().split()))

x, y = 1, 1

for i in array:
    dx, dy = dir[i][0] + x, dir[i][1] + y
    #print(dx, dy)
    if (dx <= n and dx >= 1) and (dy <= n and dy >=1):
        # 개선
        # x += dir[i][0]
        # y += dir[i][1]
        x, y = dx, dy
    # print(dx, dy)
print(x, y)

#
# 5
# R R R U D D