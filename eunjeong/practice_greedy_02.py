# 이것이 코딩테스트다 문제
# 그리디 알고리즘 
# 2 큰수의 법칙 
n, m, k = map(int, input().split())

array = list(map(int, input().split()))
array.sort(reverse=True)# 역순 정렬

# print(array)
# 결과 구하려면
# a = int(m / (k+1))
#result = a * (array[0] * k + array[1])
# result = int(m / (k+1)) * (array[0] * k + array[1])
# b = m % (k+1)
# result += (b * array[0])
# result += (m % (k+1) * array[0])

result = int(m / (k+1)) * (array[0] * k + array[1]) + (m % (k+1) * array[0])

print(result)

# input 예제
# 5 8 3
# 2 4 5 4 6