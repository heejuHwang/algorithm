"""
여러 지방의 예산요청과 국가예산의 총액이 주어졌을 때, 
1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다.

입력
첫째 줄에는 지방의 수를 의미하는 정수 N이 주어진다. 
다음 줄에는 각 지방의 예산요청을 표현하는 N개의 정수가 빈칸을 사이에 두고 주어진다. 
그 다음 줄에는 총 예산을 나타내는 정수 M이 주어진다. 

출력
배정된 예산들 중 최댓값인 정수를 출력한다. 
"""

n = int(input())
budgets = list(map(int,input().split(' ')))
total = int(input())
sumBudget = sum(budgets)

def get_max(total):  
    #상한액이 예산최대값인 경우
    if sumBudget <= total:
        return max(budgets)
    
    #이진탐색을 이용하여 최대 상한액을 구한다.
    else:
        l = 0
        r = max(budgets)
        a = 0
        while l <= r :
            mid = (r+l)//2
            sum = 0
            #mid보다 작은 예산은 그대로, 큰 예산은 mid값으로 더한다.
            for i in range(0,n):
                if budgets[i] <= mid:
                    sum = sum + budgets[i]
                else:
                    sum = sum + mid
            if sum == total:
                return mid
            # 총예산을 넘기지 않는 최대 상한액을 구하는 것이기때문에 a에 현재 mid값 저장
            if sum <total :
                l = mid+1    
                a = mid   
            else:
                r = mid-1
        #만약 이진탐색 후에도 총예산에 정확히 맞아 떨어지는 상한액이 없으면, 저장해둔 a값 return
        return a

print(get_max(total))