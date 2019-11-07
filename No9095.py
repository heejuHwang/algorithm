"""
9095번 공통문제
"""
# t개의 입력을 list로 받는다
t = int(input())
inputs = []
for i in range(t):
  inputs.append(int(input()))

# 정수 1,2,3일때의 방법의 수
m = [1, 2, 4]

# 정수 4~10일 때의 방법의 수
for i in range(3,10):
  m.append(m[i-3]+m[i-2]+m[i-1])

# 각 입력에 대한 결과를 출력
for a in inputs:
  print(m[a-1])