"""
No 10422
"""

t = int(input())
lens = list(input().split(' '))

# L의 최대값만큼의 길이가 x인 리스트를 만든다.
m = [[0 for _ in range(2)]for _ in range(5001)]

# 올바른 괄호 문자열은 길이가 짝수일때만 가능하다.
# 0번째 칸 ; 길이가 2 작은 괄호를 감싸는 경우. 중복된 경우가 없다.
# 1번째 칸 ; 그 외의 경우
m[2][0] = 1 
for k in range(2,2501):
  for l in range(1,k):
    m[2*k][1] = m[2*k][1] + m[2*l][0] * m[2*k-2*l][0] 
    m[2*k][1] = m[2*k][1] + m[2*l][0] * m[2*k-2*l][1]
  m[2*k][0] = m[2*k-2][0] + m[2*k-2][1]


for l in lens:
  print((m[int(l)][0] + m[int(l)][1]) % 1000000007)