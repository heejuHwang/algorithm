"""
백준 No.1920 https://www.acmicpc.net/problem/1920
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
"""

# N개의 정수를 A리스트에 담고 정렬한다.
N = int(input())
A = list(input().split(' '))
A.sort()

# 찾아야 하는 M개의 정수를 입력받아서 B리스트에 담는다.
M = int(input())
B = list(input().split(' '))

# B의 각 원소에 대하여 이진탐색을 수행, A에 존재하는지 알아낸다.
def find(num):
  l = 0
  r = N-1
  while l <= r:    
    mid = (l+r)//2
    if A[mid] == num:
      return 1
    elif A[mid] > num:
      r = mid-1
    else:
      l = mid+1
  return 0

for b in B:
  print(find(b))